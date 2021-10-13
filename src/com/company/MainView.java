package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    private Scanner scanner;
    private int[] sumsDiagonals;
    private Matrix matrix;
    private boolean newMatrix = true;
    private boolean end;

    public void doTaskWithMatrix(){
        int rows, columns;
        scanner = new Scanner(System.in);
        while (!end) {
            try {
                if (newMatrix) {
                    System.out.println("To create a matrix, you must enter its size.\nEnter the number of lines:");
                    rows = scanner.nextInt();
                    System.out.println("Enter the number of columns:");
                    columns = scanner.nextInt();
                    matrix = new Matrix(rows, columns);
                    choiceMatrixFillingMethod();
                }
                System.out.println("\nYour matrix:" + matrix.toString());
                choiceMethodCalculatingSumsDiagonalsMatrix();
                int i = 1;
                for (int value : sumsDiagonals) {
                    System.out.println("The sum of the elements of the " + i + " diagonal = " + value);
                    i++;
                }
                choiceFurtherScenario();
            } catch (Exception e) {
                end = true;
                System.out.println("\nThe program crashed.");
            }
        }
        System.out.println("\nCompletion of work.");
    }

    private void choiceMethodCalculatingSumsDiagonalsMatrix(){
        System.out.println("Select the angle of calculating the sums of the diagonals of the matrix (enter the number):\n" +
                "1. Calculating the sums of the diagonals starting from the lower right corner.\n" +
                "2. Calculating the sums of the diagonals starting from the lower left corner.\n" +
                "3. Calculating the sums of the diagonals starting from the upper left corner.\n" +
                "4. Calculating the sums of the diagonals starting from the upper right corner.");
        switch (scanner.nextInt()){
            case 1:
                sumsDiagonals = MatrixDiagonalsSumsCalculator.calculateSumsDiagonalsFromBottomRightToTopLeft(matrix);
                break;
            case 2:
                sumsDiagonals = MatrixDiagonalsSumsCalculator.calculateSumsDiagonalsFromBottomLeftToTopRight(matrix);
                break;
            case 3:
                sumsDiagonals = MatrixDiagonalsSumsCalculator.calculateSumsDiagonalsFromTopLeftToBottomRight(matrix);
                break;
            case 4:
                sumsDiagonals = MatrixDiagonalsSumsCalculator.calculateSumsDiagonalsFromTopRightToBottomLeft(matrix);
                break;
            default:
                System.out.println("\nInvalid number! Enter a number between 1 and 4.");
        }
        System.out.println();
    }

    private void choiceFurtherScenario(){
        System.out.println("\nDo you want to continue (enter the number)?\n" +
                "1. Yes.\n" +
                "2. No.");
        switch (scanner.nextInt()){
            case 1:
                end = false;
                System.out.println("\nChoose an action (enter the number):\n" +
                        "1. Create a new matrix.\n" +
                        "2. Continue with the current.");
                switch (scanner.nextInt()){
                    case 1:
                        newMatrix = true;
                        System.out.println();
                        break;
                    case 2:
                        newMatrix = false;
                        break;
                    default:
                        System.out.println("\nInvalid number! Enter a number between 1 and 2.");
                        throw new InputMismatchException();
                }
                break;
            case 2:
                end = true;
                break;
            default:
                System.out.println("\nInvalid number! Enter a number between 1 and 2.");
                throw new InputMismatchException();
        }
    }

    private void choiceMatrixFillingMethod(){
        System.out.println("\nSelect a matrix filling method (enter the number):\n" +
                "1. Console input.\n" +
                "2. Filling with random numbers.");
        switch (scanner.nextInt()){
            case 1:
                System.out.println("\nEnter the elements of the matrix (filling line by line):");
                MatrixCreator.fillFromConsole(matrix);
                break;
            case 2:
                int start, end;
                System.out.println("\nEnter the boundaries of the random values (minimum start and end values).\n" +
                        "From:");
                start = scanner.nextInt();
                System.out.println("To:");
                end = scanner.nextInt();
                MatrixCreator.fillRandomized(matrix, start, end);
                break;
            default:
                System.out.println("\nInvalid number! Enter a number between 1 and 2.");
                throw new InputMismatchException();
        }
    }

}
