package com.zero.euler.level001;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class A24LexicographicPermutations {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(0, 1, 2);
        int limit = 5;
        String result = findPermutationSeq(numbers, limit);
        log.info("Permutasi ke-5 adalah: {}", result);

        numbers = IntStream.range(0, 10).boxed().toList();
        limit = 1_000_000;
        result = findPermutationSeq(numbers, limit);
        log.info("Permutasi ke-1000000 adalah: {}", result);
    }

    /**
     * Menghasilkan urutan permutasi ke-k dari daftar angka secara leksikografis
     * tanpa menghasilkan semua permutasi satu per satu.
     *
     * @param values Daftar angka unik yang ingin dipermutasi (misal: [0,1,2,3,4,5,6,7,8,9])
     * @param limit  Urutan ke berapa dari permutasi yang ingin dicari (dimulai dari 1)
     * @return String hasil permutasi pada urutan ke-limit
     * <p>
     * Langkah-langkah algoritma:
     * 1. Salin daftar angka ke dalam list baru untuk memudahkan modifikasi (penghapusan angka yang sudah dipakai).
     * 2. Ulangi selama masih ada angka yang belum dipilih:
     * a. Hitung faktorial dari sisa angka - 1 (size - 1) → ini menunjukkan jumlah permutasi dalam setiap blok.
     * b. Hitung indeks digit saat ini dengan rumus: (limit - 1) / factorial
     * - Rumus ini menunjukkan digit keberapa yang akan dipilih di posisi saat ini.
     * - Kita kurangi 1 dari limit karena indeks dimulai dari 0, tapi urutan dimulai dari 1.
     * c. Ambil angka pada index tersebut dan tambahkan ke hasil.
     * d. Hapus angka itu dari daftar karena sudah digunakan.
     * e. Perbarui limit agar menunjukkan posisi relatif dalam blok saat ini:
     * limit = limit - (index * factorial)
     * 3. Setelah semua angka dipilih, kembalikan hasil sebagai string.
     */
    public static String findPermutationSeq(List<Integer> values, int limit) {
        List<Integer> numbers = new ArrayList<>(values);
        StringBuilder result = new StringBuilder();

        while (!numbers.isEmpty()) {
            int size = numbers.size();
            int factorial = factorial(size - 1);
            int index = (limit - 1) / factorial;

            int digit = numbers.get(index);
            result.append(digit);
            numbers.remove(index);

            limit = limit - (index * factorial);
        }
        return result.toString();
    }

    public static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

}
