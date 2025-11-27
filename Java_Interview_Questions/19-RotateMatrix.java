/**
 * Question 19: Rotate Matrix
 * Problem: Rotate a matrix 90 degrees clockwise
 * 
 * Example:
 * Input: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
 */

import java.util.*;

public class RotateMatrix {
    
    // Using transpose and reverse
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    // Counter-clockwise rotation
    public static void rotateMatrixCounterClockwise(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[bottom][j];
                matrix[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }
    
    // Layer by layer rotation (space efficient)
    public static void rotateMatrixLayerByLayer(int[][] matrix) {
        int n = matrix.length;
        
        for (int layer = 0; layer < Math.floor(n / 2.0); layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int i = first; i < last; i++) {
                int offset = i - first;
                
                // Save top
                int top = matrix[first][i];
                
                // Move left to top
                matrix[first][i] = matrix[last - offset][first];
                
                // Move bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // Move right to bottom
                matrix[last][last - offset] = matrix[i][last];
                
                // Move top to right
                matrix[i][last] = top;
            }
        }
    }
    
    // Print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix1);
        System.out.println("Rotated 90° clockwise:");
        printMatrix(matrix1);
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixCounterClockwise(matrix2);
        System.out.println("Rotated 90° counter-clockwise:");
        printMatrix(matrix2);
        // [[3, 6, 9], [2, 5, 8], [1, 4, 7]]
        
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixLayerByLayer(matrix3);
        System.out.println("Layer by layer rotation:");
        printMatrix(matrix3);
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        
        // Test with even-sized matrix
        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrix(matrix4);
        System.out.println("4x4 matrix rotated:");
        printMatrix(matrix4);
    }
}
