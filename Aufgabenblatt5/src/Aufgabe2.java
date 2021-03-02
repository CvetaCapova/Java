/*
    Aufgabe 2) Zweidimensionale Arrays und Rekursion - Sudoku
*/

import java.util.Arrays;

public class Aufgabe2 {
    
    private static final int sSize = 9; //sudoku field size ==> 9x9
    private static final int subSize = 3; //sudoku subfield size ==> 3x3
    
    private static int[][] readArrayFromFile(String filename) {
        In fileReader = new In(filename);
        int[][] output = new int[9][9];
        for (int i = 0; i < output.length; i++) {
            String[] row = fileReader.readLine().split(";");
            int[] rowNum = new int[9];
            for (int j = 0; j < 9; j++) {
                rowNum[j] = Integer.parseInt(row[j]);
            }
            output[i]=rowNum;
        }

        return output; //Zeile kann geändert oder entfernt werden.
    }
    
    private static boolean solveSudoku(int[][] array, int idx) {
        if (idx > (sSize * sSize - 1)) {
            return true;
        } else {
            if (array[idx / sSize][idx % sSize] == 0) {
                for (int num = 1; num <= sSize; num++) {
                    if (!isNumUsedInRow(array, num, idx / sSize) && !isNumUsedInCol(array, num, idx % sSize) && !isNumUsedInBox(array, num, idx / sSize - ((idx / sSize) % subSize), idx % sSize - ((idx % sSize) % subSize))) {
                        array[idx / sSize][idx % sSize] = num;
                        if (solveSudoku(array, idx + 1)) {
                            return true;
                        } else {
                            array[idx / sSize][idx % sSize] = 0;
                        }
                    }
                }
            } else {
                return solveSudoku(array, idx + 1);
            }
        }
        return false;
    }
    
    private static boolean isNumUsedInBox(int[][] array, int num, int row, int col) {
        boolean containsNum = false;
        for (int i = row; i <row+3 ; i++) {
            for (int j = col; j < col+3; j++) {
                if(array[i][j]==num){
                    containsNum=true;
                }
            }
        }
        return containsNum; //Zeile kann geändert oder entfernt werden.
    }
    
    private static boolean isNumUsedInRow(int[][] array, int num, int row) {
        boolean containsNum = false;
        for (int i = 0; i < 9; i++) {
            if (array[row][i]==num){
                containsNum=true;
            }
        }
        return containsNum;
    }
    
    private static boolean isNumUsedInCol(int[][] array, int num, int col) {
        boolean containsNum = false;
        for (int i = 0; i < 9; i++) {
            if (array[i][col]==num){
                containsNum=true;
            }
        }
        return containsNum;
    }
    
    private static boolean isValidSudokuSolution(int[][] array) {
        int[] num1to9 = {1,2,3,4,5,6,7,8,9};
        int [] num0to8 = {0,1,2,3,4,5,6,7,8};
        boolean solvedSudoku = false;
        boolean solvedRow = true;
        boolean solvedCol = true;
        boolean solvedBox = true;
        for (int num:num1to9) {
            for (int rowCol:num0to8) {
                if (isNumUsedInRow(array,num,rowCol)==false){
                    solvedRow = false;
                }
                if (isNumUsedInCol(array,num,rowCol)==false){
                    solvedCol=false;
                }
            }

            for (int i = 0; i <= 6; i+=3) {
                for (int j = 0; j <= 6; j+=3) {
                    if (isNumUsedInBox(array,num,i,j)==false){
                        solvedBox=false;
                    }
                }
            }
        }

        if (solvedBox==true && solvedCol==true && solvedRow==true){
            solvedSudoku=true;
        }
        return solvedSudoku;
    }
    
    private static void printArray(int[][] inputArray) {
        for (int y = 0; y < inputArray.length; y++) {
            for (int x = 0; x < inputArray[y].length; x++) {
                System.out.print(inputArray[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        String filename = "sudoku0.csv"; //sudoku0.csv - sudoku7.csv available!
        System.out.println("Reading " + filename + " ...");
        int[][] sudokuField = readArrayFromFile(filename);
        printArray(sudokuField);

        solveSudoku(sudokuField, 0);

        System.out.println("Sudoku solved");
        System.out.println("Valid solution: " + isValidSudokuSolution(sudokuField));
        printArray(sudokuField);
    }
}


