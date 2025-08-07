package com.zero.encryption;

import com.zero.CustomException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
public class AES {

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = generateKey2();
        log.info("secret key : {}", secretKey);

        byte[] iv1 = generateIv2();
        log.info("iv1 : {}", iv1);

        byte[] iv2 = generateIv();
        log.info("iv2 : {}", iv2);

        String hello1 = encrypt("hello", secretKey, iv1);
        log.info("encrypted with iv 1 : {}", hello1);

        String hello2 = encrypt("hello", secretKey, iv2);
        log.info("encrypted with iv 2 : {}", hello2);

        String decrypted1 = decrypt(hello1, secretKey);
        log.info("decrypted : {}", decrypted1);

        String decrypted2 = decrypt(hello2, secretKey);
        log.info("decrypted : {}", decrypted2);
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

    public static SecretKey generateKey2() {
        String rawKey = "inikuncirahasia1"; // 16 karakter = 128 bit
        byte[] keyBytes = rawKey.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static byte[] generateIv2() {
        return new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }
}
