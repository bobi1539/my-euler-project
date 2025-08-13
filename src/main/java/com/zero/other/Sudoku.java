package com.zero.other;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Sudoku {

    public static void main(String[] args) {

        int[][] sudokuEasy = new int[][]{
                {4, 0, 7, 0, 0, 0, 9, 1, 0},
                {0, 1, 5, 0, 0, 2, 6, 0, 0},
                {0, 8, 3, 0, 1, 0, 2, 5, 0},
                {8, 0, 1, 0, 9, 0, 0, 4, 5},
                {0, 5, 6, 7, 4, 0, 8, 9, 1},
                {3, 0, 0, 0, 0, 1, 0, 0, 6},
                {0, 0, 2, 8, 0, 0, 0, 0, 0},
                {5, 9, 0, 0, 7, 4, 1, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 3, 8},
        };

        solve(sudokuEasy);

        int[][] sudokuMedium = new int[][]{
                {7, 0, 4, 9, 0, 0, 5, 6, 8},
                {0, 1, 0, 0, 0, 0, 3, 4, 0},
                {0, 8, 0, 2, 0, 4, 1, 0, 0},
                {8, 0, 5, 1, 0, 2, 0, 0, 4},
                {0, 0, 0, 5, 3, 8, 0, 0, 0},
                {2, 3, 1, 4, 7, 9, 0, 0, 0},
                {1, 7, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 2, 0, 9, 1, 0, 0, 0},
                {0, 0, 0, 7, 2, 0, 8, 0, 1},
        };

        solve(sudokuMedium);

        int[][] sudokuHard = new int[][]{
                {0, 1, 0, 0, 0, 0, 9, 2, 0},
                {4, 0, 0, 7, 0, 0, 0, 5, 0},
                {5, 6, 0, 0, 9, 1, 0, 7, 3},
                {0, 0, 7, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 7, 0, 0},
                {0, 0, 0, 4, 7, 9, 6, 8, 5},
                {0, 0, 0, 9, 0, 0, 5, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 4, 2},
                {8, 0, 0, 0, 0, 4, 1, 0, 0},
        };

        solve(sudokuHard);
    }

    public static void solve(int[][] sudoku) {
        log.info("============START============");
        Map<List<Integer>, Set<Integer>> map = new HashMap<>();
        int numberOfCheck = 1;
        check(sudoku, numberOfCheck);
        while (!isSudokuComplete(sudoku)) {
            findNumberInRowColumn(sudoku, map);
            changeValue(sudoku, map);
            check(sudoku, numberOfCheck);
            numberOfCheck += 1;
        }
        log.info("============FINISH============");
    }

    private static void check(int[][] sudoku, int numberOfCheck) {
        log.info("number of check : {}", numberOfCheck);
        for (int[] ints : sudoku) {
            log.info("result : {}", ints);
        }
    }

    private static void findNumberInRowColumn(int[][] sudoku, Map<List<Integer>, Set<Integer>> map) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int number = sudoku[row][col];
                if (number == 0) {
                    addKeyValueRowColumnIntoMap(sudoku, map, row, col);
                }
            }
        }
    }

    private static void addKeyValueRowColumnIntoMap(int[][] sudoku, Map<List<Integer>, Set<Integer>> map, int row, int col) {
        List<Integer> key = List.of(row, col);
        Set<Integer> setValue = map.getOrDefault(key, new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        for (int i = 0; i < 9; i++) {
            int rowNumber = sudoku[row][i];
            setValue.remove(rowNumber);

            int colNumber = sudoku[i][col];
            setValue.remove(colNumber);
        }

        removeNumberInBox(sudoku, row, col, setValue);

        map.put(key, setValue);
    }

    private static void removeNumberInBox(int[][] sudoku, int row, int col, Set<Integer> setValue) {
        if (row < 3 && col < 3) {
            removeSetOfNumberInBox(sudoku, setValue, 0, 3, 0, 3);
        } else if (row < 3 && col < 6) {
            removeSetOfNumberInBox(sudoku, setValue, 0, 3, 3, 6);
        } else if (row < 3 && col < 9) {
            removeSetOfNumberInBox(sudoku, setValue, 0, 3, 6, 9);
        } else if (row < 6 && col < 3) {
            removeSetOfNumberInBox(sudoku, setValue, 3, 6, 0, 3);
        } else if (row < 6 && col < 6) {
            removeSetOfNumberInBox(sudoku, setValue, 3, 6, 3, 6);
        } else if (row < 6 && col < 9) {
            removeSetOfNumberInBox(sudoku, setValue, 3, 6, 6, 9);
        } else if (row < 9 && col < 3) {
            removeSetOfNumberInBox(sudoku, setValue, 6, 9, 0, 3);
        } else if (row < 9 && col < 6) {
            removeSetOfNumberInBox(sudoku, setValue, 6, 9, 3, 6);
        } else {
            removeSetOfNumberInBox(sudoku, setValue, 6, 9, 6, 9);
        }
    }

    private static void removeSetOfNumberInBox(
            int[][] sudoku,
            Set<Integer> setValue,
            int rowStart,
            int rowEnd,
            int colStart,
            int colEnd
    ) {

        if (setValue.size() == 1) return;
        for (int row = rowStart; row < rowEnd; row++) {
            for (int col = colStart; col < colEnd; col++) {
                int number = sudoku[row][col];
                setValue.remove(number);
            }
        }
    }

    private static void changeValue(int[][] sudoku, Map<List<Integer>, Set<Integer>> map) {
        for (Map.Entry<List<Integer>, Set<Integer>> entry : map.entrySet()) {
            List<Integer> key = entry.getKey();
            Set<Integer> value = entry.getValue();

            if (value.size() == 1) {
                Integer i = value.stream().findFirst().orElse(0);
                sudoku[key.get(0)][key.get(1)] = i;
            }
        }
    }

    private static boolean isSudokuComplete(int[][] sudoku) {
        for (int[] ints : sudoku) {
            for (int i : ints) {
                if (i == 0) return false;
            }
        }
        return true;
    }

}
