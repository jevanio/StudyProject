package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int numElements = matrix.length * matrix[0].length;
        int left = 0;
        int down = matrix.length - 1;
        int up = 0;
        int right = matrix[0].length - 1;
        List<Integer> orderedMatrix = new ArrayList<>();
        while (orderedMatrix.size() < numElements) {
            up = moveRight(matrix, numElements, left, up, right, orderedMatrix);

            right = moveDown(matrix, numElements, down, up, right, orderedMatrix);

            down = moveLeft(matrix, numElements, left, down, right, orderedMatrix);

            left = moveUp(matrix, numElements, left, down, up, orderedMatrix);
        }

        return orderedMatrix;
    }

    private int moveUp(int[][] matrix, int numElements, int left, int down, int up, List<Integer> orderedMatrix) {
        for (int i = down; i >= up && orderedMatrix.size() < numElements; i--) {
            orderedMatrix.add(matrix[i][left]);
        }
        return ++left;
    }

    private int moveLeft(int[][] matrix, int numElements, int left, int down, int right, List<Integer> orderedMatrix) {
        for (int i = right; i >= left && orderedMatrix.size() < numElements; i--) {
            orderedMatrix.add(matrix[down][i]);
        }
        return --down;
    }

    private int moveDown(int[][] matrix, int numElements, int down, int up, int right, List<Integer> orderedMatrix) {
        for (int i = up; i <= down && orderedMatrix.size() < numElements; i++) {
            orderedMatrix.add(matrix[i][right]);
        }
        return --right;
    }

    private int moveRight(int[][] matrix, int numElements, int left, int up, int right, List<Integer> orderedMatrix) {
        for (int i = left; i <= right && orderedMatrix.size() < numElements; i++) {
            orderedMatrix.add(matrix[up][i]);
        }
        return ++up;
    }

}
