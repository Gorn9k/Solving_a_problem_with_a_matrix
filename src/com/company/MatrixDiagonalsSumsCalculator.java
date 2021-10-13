package com.company;

public class MatrixDiagonalsSumsCalculator {

    public static int[] calculateSumsDiagonalsFromBottomRightToTopLeft(Matrix matrix){
        return calculateSumsDiagonalsMatrixUsingCornerAndMovementDirection(matrix, matrix.getVerticalSize() - 1, -1, matrix.getHorizontalSize() - 1, -1);
    }

    public static int[] calculateSumsDiagonalsFromTopLeftToBottomRight(Matrix matrix){
        return calculateSumsDiagonalsMatrixUsingCornerAndMovementDirection(matrix, 0, 1, 0, 1);
    }

    public static int[] calculateSumsDiagonalsFromBottomLeftToTopRight(Matrix matrix){
        return calculateSumsDiagonalsMatrixUsingCornerAndMovementDirection(matrix, matrix.getVerticalSize() - 1, -1, 0, 1);
    }

    public static int[] calculateSumsDiagonalsFromTopRightToBottomLeft(Matrix matrix){
        return calculateSumsDiagonalsMatrixUsingCornerAndMovementDirection(matrix, 0, 1, matrix.getHorizontalSize() - 1, -1);
    }

    private static int[] calculateSumsDiagonalsMatrixUsingCornerAndMovementDirection(Matrix matrix, int lineCorner, int lineMovementDirection, int columnCorner, int columnMovementDirection){
        int[] sumsDiagonals = new int[matrix.getVerticalSize() + matrix.getHorizontalSize() - 1];
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                sumsDiagonals[j + i] += matrix.getElement(lineCorner + lineMovementDirection*i, columnCorner + columnMovementDirection*j);
            }
        }
        return sumsDiagonals;
    }

}
