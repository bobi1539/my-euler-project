package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class A022NamesScores {

    public static void main(String[] args) {
        log.info("name scores from file : {}", countNameScore());
        log.info("name scores from file : {}", countNameScoreV2());
    }

    public static long countNameScore() {
        String filePath = "src/main/resources/names.txt";
        String[] names = readFileTxt(filePath).split(",");
        Arrays.sort(names);

        long sumOfNameScore = 0;
        for (int i = 0; i < names.length; i++) {
            long charNameSum = 0;
            String name = names[i].replace("\"", "").toLowerCase();
            for (char c : name.toCharArray()) {
                charNameSum += (c - '0') - 48;
            }
            sumOfNameScore += charNameSum * (i + 1);

        }
        return sumOfNameScore;
    }

    public static long countNameScoreV2() {
        String filePath = "src/main/resources/names.txt";
        String[] names = readFileTxt(filePath).split(",");
        Arrays.sort(names);

        long sumOfNameScore = 0;
        for (int i = 0; i < names.length; i++) {
            long charNameSum = 0;
            String name = names[i].replace("\"", "");
            for (char c : name.toCharArray()) {
                charNameSum += (c - 'A') + 1;
            }
            sumOfNameScore += charNameSum * (i + 1);

        }
        return sumOfNameScore;
    }


    public static String readFileTxt(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

}
