package com.happyTeam.yay;

import java.util.Arrays;

public class CheckBoard {
    public static void main(String[] args) {

    }

    public static String[][] convertIntArrayToStringArray(int[][] board) {
        String[][] boardAsStrings = new String[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardAsStrings[i][j] = Integer.toString(board[i][j]);
            }
        }
        return boardAsStrings;
    }

    public static boolean checkBoard(String[][] board) {

        // In the context that this will be used in, it will be a given that the input is a
        // two-dimensional array (9*9), each item being 1-9 (or 0 for a blank square).

        // The variable type of the numbers may be different, but a separate method will account
        // for that.

        // checks each array (i.e. each row) is 1-9
        for (int i = 0; i < board.length; i++) {
            String[] arrayCopy = board[i].clone();
            String lineAsString = String.join("", arrayCopy);
            char[] charArray = lineAsString.toCharArray();
            Arrays.sort(charArray);
            String charArrayToString = new String(charArray);
            String sortedNumbers = "123456789";
            if (charArrayToString.compareTo(sortedNumbers) != 0) {
                return false;
            }
        }

        // rewrites board into arrays representing columns; checks columns
        String[] columns = new String[81];
        int columnsArrayIndex = 0;
        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[j].length; k++) {
                columns[columnsArrayIndex] = board[k][j];
                columnsArrayIndex++;
            }
        }
        for (int l = 0; l < 9; l++) {
            int number = l * 9;
            String[] column = Arrays.copyOfRange(columns, number, number + 9);
            Arrays.sort(column);
            String joinedColumn = String.join("", column);
            String sortedNumbers = "123456789";
            if (joinedColumn.compareTo(sortedNumbers) != 0) {
                return false;
            }
        }

        // rewrites board into arrays representing squares; checks squares
        String[] squares = new String[81];
        int squaresIndex = 0;
        for (int n = 0; n < 81; n += 9) {
            squares[squaresIndex] = columns[n];
            squaresIndex++;
            squares[squaresIndex] = columns[n + 1];
            squaresIndex++;
            squares[squaresIndex] = columns[n + 2];
            squaresIndex++;
        }
        for (int n = 3; n < 81; n += 9) {
            squares[squaresIndex] = columns[n];
            squaresIndex++;
            squares[squaresIndex] = columns[n + 1];
            squaresIndex++;
            squares[squaresIndex] = columns[n + 2];
            squaresIndex++;
        }
        for (int n = 6; n < 81; n += 9) {
            squares[squaresIndex] = columns[n];
            squaresIndex++;
            squares[squaresIndex] = columns[n + 1];
            squaresIndex++;
            squares[squaresIndex] = columns[n + 2];
            squaresIndex++;
        }
        String[][] squaresArray = new String[9][9];
        int squaresArrayIndex = 0;
        for (int a = 0; a < squares.length; a += 9) {
            squaresArray[squaresArrayIndex] = Arrays.copyOfRange(squares, a, a + 9);
            squaresArrayIndex++;
        }
        for (int b = 0; b < 9; b++) {
            Arrays.sort(squaresArray[b]);
            String joinedSquare = String.join("", squaresArray[b]);
            String sortedNumbers = "123456789";
            if (joinedSquare.compareTo(sortedNumbers) != 0) {
                return false;
            }
        }

        return true;
    }
}
