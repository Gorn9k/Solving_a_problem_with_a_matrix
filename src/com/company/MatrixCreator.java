package com.company;

import java.util.Scanner;

public class MatrixCreator {

    public static void fillRandomized(Matrix matrix, int start, int end){
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                int value = (int)(Math.random() * (end - start) + start);
                matrix.setElement(i, j, value);
            }
        }
    }

    public static void fillFromConsole(Matrix matrix){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                matrix.setElement(i, j, scanner.nextInt());
            }
        }
    }
}
