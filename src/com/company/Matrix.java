package com.company;

public class Matrix {

    private int[][] array;

    Matrix(int rows, int columns){
        array = new int[rows][columns];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix: " + array.length + "x" + array[0].length +"\n");
        for (int[] row : array){
            for (int value : row){
                s.append(value + "\t");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public int getVerticalSize(){
        return array.length;
    }

    public int getHorizontalSize(){
        return array[0].length;
    }

    public int getElement(int i, int j){
        return array[i][j];
    }

    public void setElement(int i, int j, int value){
        array[i][j] = value;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

}
