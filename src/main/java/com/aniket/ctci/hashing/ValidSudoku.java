package com.aniket.ctci.hashing;

import java.util.*;

public class ValidSudoku {

    /**
     * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

     The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.


     The input corresponding to the above configuration :

     ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
     A partially filled sudoku which is valid.

     Note:
     A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     */

    static boolean[] checker = new boolean[9];

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("53..7....");
        list.add("6..195...");
        list.add(".98....6.");
        list.add("8...6...3");
        list.add("4..8.3..1");
        list.add("7...2...6");
        list.add(".6....28.");
        list.add("...419..5");
        list.add("....8..79");

        System.out.println(new ValidSudoku().isValidSudoku(list));
    }

    /*Another solution*/
    public int isValidSudoku1(final List<String> a) {
        Map<Integer, Set<Character>> col = new HashMap<>(); // map to check if cols are valid
        Map<Integer, Set<Character>> row = new HashMap<>(); // map to check if rows are valid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { // we have 9 3x3 squares
                Set<Character> set = new HashSet<>(); // set to check if 3x3 square is valid
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) { // for every 3x3 square
                        int c = 3 * j + n;
                        int r = 3 * i + m;

                        char x = a.get(r).charAt(c);

                        if (x == '.') {
                            continue;
                        }

                        if (!col.containsKey(c)) {
                            col.put(c, new HashSet<>());
                        }
                        if (!row.containsKey(r)) {
                            row.put(r, new HashSet<>());
                        }

                        if (set.contains(x) || col.get(c).contains(x) || row.get(r).contains(x))  {
                            return 0;
                        } else {
                            set.add(x);
                            col.get(c).add(x);
                            row.get(r).add(x);
                        }
                    }
                }
            }
        }

        return 1;
    }

    public int isValidSudoku(final List<String> A) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(A, i)) return 0;
        }

        for (int i = 0; i < 9; i++) {
            if (!checkCol(A, i)) return 0;
        }

        if (!checkBox(A, 0, 0)) return  0;
        if (!checkBox(A, 0, 3)) return  0;
        if (!checkBox(A, 0, 6)) return  0;
        if (!checkBox(A, 3, 0)) return  0;
        if (!checkBox(A, 3, 3)) return  0;
        if (!checkBox(A, 3, 6)) return  0;
        if (!checkBox(A, 6, 0)) return  0;
        if (!checkBox(A, 6, 3)) return  0;
        if (!checkBox(A, 6, 6)) return  0;

        return 1;
    }

    private boolean checkRow(final List<String> A, int row) {
        Arrays.fill(checker, false);
        for (int i = 0; i < 9; i++) {
            char c = A.get(row).charAt(i);
            if(c == '.') continue;
            if (checker[c - '0' - 1]) return false;
            checker[c - '0' - 1] = true;
        }
        return true;
    }

    private boolean checkCol(final List<String> A, int col) {
        Arrays.fill(checker, false);
        for (int i = 0; i < 9; i++) {
            char c = A.get(i).charAt(col);
            if(c == '.') continue;
            if (checker[c - '0' - 1]) return false;
            checker[c - '0' - 1] = true;
        }
        return true;
    }

    private boolean checkBox(final List<String> A, int row, int col) {
        Arrays.fill(checker, false);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = A.get(i).charAt(j);
                if(c == '.') continue;
                if (checker[c - '0' - 1]) return false;
                checker[c - '0' - 1] = true;
            }
        }
        return true;
    }
}
