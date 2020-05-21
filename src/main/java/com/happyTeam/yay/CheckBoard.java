package com.happyTeam.yay;

import java.util.Arrays;

public class CheckBoard {
    public static void main(String[] args) {

    }

    public static String[][] convertIntArrayToStringArray(int[][] board) {

        // We'll know if we'll need to call this later.

        String[][] boardAsStrings = new String[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardAsStrings[i][j] = Integer.toString(board[i][j]);
            }
        }
        return boardAsStrings;
    }

    public static boolean checkBoard(String[][] board) {

        String sortedNumbers = "123456789";

        // It should be a given that the input is a two-dimensional array (9*9), each item being 1-9
        // (or 0 for a blank square), but we will add error handling for those things anyway...

        if (board.length != 9) {
            // TODO: What do we want to do in this case?
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i].length != 9) {
                // TODO: What do we want to do in this case?
            }
        }

        // checks each array (i.e. each row) is 1-9
        for (int i = 0; i < board.length; i++) {
            String[] arrayCopy = board[i].clone();
            String lineAsString = String.join("", arrayCopy);
            char[] charArray = lineAsString.toCharArray();
            Arrays.sort(charArray);
            String charArrayToString = new String(charArray);
            if (charArrayToString.compareTo(sortedNumbers) != 0) {
                return false;
            }
        }

        // rewrites board into arrays representing columns; checks columns
        String[] columns = new String[81];
        int columnsArrayIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                columns[columnsArrayIndex] = board[j][i];
                columnsArrayIndex++;
            }
        }
        for (int i = 0; i < 9; i++) {
            int number = i * 9;
            String[] column = Arrays.copyOfRange(columns, number, number + 9);
            Arrays.sort(column);
            String joinedColumn = String.join("", column);
            if (joinedColumn.compareTo(sortedNumbers) != 0) {
                return false;
            }
        }

        // rewrites board into arrays representing squares; checks squares
        String[] squares = new String[81];
        int squaresIndex = 0;
        for (int i = 0; i < 81; i += 9) {
            squares[squaresIndex] = columns[i];
            squaresIndex++;
            squares[squaresIndex] = columns[i + 1];
            squaresIndex++;
            squares[squaresIndex] = columns[i + 2];
            squaresIndex++;
        }
        for (int i = 3; i < 81; i += 9) {
            squares[squaresIndex] = columns[i];
            squaresIndex++;
            squares[squaresIndex] = columns[i + 1];
            squaresIndex++;
            squares[squaresIndex] = columns[i + 2];
            squaresIndex++;
        }
        for (int i = 6; i < 81; i += 9) {
            squares[squaresIndex] = columns[i];
            squaresIndex++;
            squares[squaresIndex] = columns[i + 1];
            squaresIndex++;
            squares[squaresIndex] = columns[i + 2];
            squaresIndex++;
        }
        String[][] squaresArray = new String[9][9];
        int squaresArrayIndex = 0;
        for (int i = 0; i < squares.length; i += 9) {
            squaresArray[squaresArrayIndex] = Arrays.copyOfRange(squares, i, i + 9);
            squaresArrayIndex++;
        }
        for (int i = 0; i < 9; i++) {
            Arrays.sort(squaresArray[i]);
            String joinedSquare = String.join("", squaresArray[i]);
            if (joinedSquare.compareTo(sortedNumbers) != 0) {
                return false;
            }
        }

        return true;
    }
}
