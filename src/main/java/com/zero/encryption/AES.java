package com.zero.encryption;

import com.zero.CustomException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
public class AES {

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = generateKey();
        log.info("secret key : {}", secretKey);

        byte[] iv = generateIv();
        log.info("iv : {}", iv);

        String encrypted = encrypt("hello", secretKey, iv);
        log.info("encrypted : {}", encrypted);

        String decrypted = decrypt(encrypted, secretKey);
        log.info("decrypted : {}", decrypted);
    }

    private static final int AES_KEY_SIZE = 128; // atau 256 jika diizinkan
    private static final int IV_SIZE = 12;
    private static final int TAG_LENGTH_BIT = 128;

    public static String encrypt(String plainText, SecretKey key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            byte[] encryptedWithIv = new byte[IV_SIZE + encrypted.length];
            System.arraycopy(iv, 0, encryptedWithIv, 0, IV_SIZE);
            System.arraycopy(encrypted, 0, encryptedWithIv, IV_SIZE, encrypted.length);
            return Base64.getEncoder().encodeToString(encryptedWithIv);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    public static String decrypt(String cipherText, SecretKey key) {
        try {
            byte[] decoded = Base64.getDecoder().decode(cipherText);
            byte[] iv = new byte[IV_SIZE];
            System.arraycopy(decoded, 0, iv, 0, IV_SIZE);
            GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
            byte[] original = cipher.doFinal(decoded, IV_SIZE, decoded.length - IV_SIZE);
            return new String(original);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    public static SecretKey generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(AES_KEY_SIZE);
            return keyGenerator.generateKey();
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    public static byte[] generateIv() {
        byte[] iv = new byte[IV_SIZE];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

}
