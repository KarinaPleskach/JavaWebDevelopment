package by.training.multithreading_matrix.entity;

import java.util.Arrays;

public class Matrix {

    private int[][] matrix;

    public Matrix() {}
    public Matrix(int[][] matrix) {
        this.matrix = matrix.clone();
    }

    public int[][] getMatrix() {
        return matrix.clone();
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix.clone();
    }

    public void setElement(int row, int col, int value) {
        matrix[row][col] = value;
    }

    public int getSize() {
        return matrix.length;
    }

    public int getElement(int row, int col) {
        return matrix[row][col];
    }

    @Override
    public String toString() {
        StringBuilder rezult = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                rezult.append(matrix[i][j] + " ");
            }
            rezult.append("\n");
        }
        return rezult.toString();
    }
}
