package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class A009SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        log.info("product of pythagorean triplet for which a+b+c=1000 : {}", findProductABC());
        log.info("product of pythagorean triplet for which a+b+c=1000 : {}", findProductABCV2());
    }

    public static int findProductABC() {
        int productABC = 1;
        int length = 1000;
        for (int a = 1; a <= length; a++) {
            for (int b = a + 1; b <= length; b++) {
                int c = length - b - a;
                if (power(a) + power(b) == power(c)) {
                    log.info("a : {}", a);
                    log.info("b : {}", b);
                    log.info("c : {}", c);
                    productABC = a * b * c;
                }
            }
        }
        return productABC;
    }

    /**
     * Mencari hasil kali dari triplet Pythagoras (a, b, c) yang unik
     * dengan syarat: a + b + c = 1000 dan a^2 + b^2 = c^2.
     * <p>
     * Metode ini menggunakan pendekatan brute-force yang sudah dioptimalkan
     * dengan membatasi ruang pencarian berdasarkan logika berikut:
     * <p>
     * - Karena a < b < c dan a + b + c = 1000, maka:
     * - Nilai maksimum a adalah kurang dari 1000 / 3 (~333), karena jika lebih besar,
     * maka jumlah b + c tidak akan cukup untuk memenuhi total 1000.
     * - Nilai maksimum b adalah kurang dari 1000 / 2 = 500, karena b harus lebih kecil dari c,
     * dan b + c harus melengkapi nilai a agar totalnya tetap 1000.
     * <p>
     * Dengan membatasi iterasi seperti ini, jumlah kombinasi yang dicek menjadi jauh lebih sedikit,
     * namun tetap menjamin bahwa solusi akan ditemukan jika memang ada.
     *
     * @return hasil kali a * b * c dari triplet Pythagoras yang jumlahnya 1000;
     * mengembalikan -1 jika tidak ditemukan (meskipun untuk soal ini seharusnya pasti ada).
     */
    public static int findProductABCV2() {
        int sum = 1000;
        for (int a = 1; a < sum / 3; a++) {
            for (int b = a + 1; b < sum / 2; b++) {
                int c = sum - b - a;
                if (power(a) + power(b) == power(c)) {
                    return a * b * c;
                }
            }
        }
        return 0;
    }

    public static int power(int value) {
        return value * value;
    }

}
