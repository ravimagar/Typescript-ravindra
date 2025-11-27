/**
 * Question 19: Rotate Matrix
 * Problem: Rotate a matrix 90 degrees clockwise
 * 
 * Example:
 * Input: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
 */

function rotateMatrix(matrix: number[][]): void {
  const n = matrix.length;
  
  // Transpose the matrix
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
    }
  }
  
  // Reverse each row
  for (let i = 0; i < n; i++) {
    matrix[i].reverse();
  }
}

// Rotate 90 degrees counter-clockwise
function rotateMatrixCounterClockwise(matrix: number[][]): void {
  const n = matrix.length;
  
  // Transpose the matrix
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
    }
  }
  
  // Reverse each column (not row)
  for (let j = 0; j < n; j++) {
    for (let i = 0; i < Math.floor(n / 2); i++) {
      [matrix[i][j], matrix[n - 1 - i][j]] = [matrix[n - 1 - i][j], matrix[i][j]];
    }
  }
}

// Rotate layer by layer (space efficient)
function rotateMatrixLayerByLayer(matrix: number[][]): void {
  const n = matrix.length;
  
  for (let layer = 0; layer < Math.floor(n / 2); layer++) {
    const first = layer;
    const last = n - 1 - layer;
    
    for (let i = first; i < last; i++) {
      const offset = i - first;
      
      // Save top
      const top = matrix[first][i];
      
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

// Helper function to print matrix
function printMatrix(matrix: number[][]): void {
  matrix.forEach(row => console.log(row));
}

// Test cases
const matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
rotateMatrix(matrix1);
console.log("Rotated 90° clockwise:");
printMatrix(matrix1);
// [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

const matrix2 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
rotateMatrixCounterClockwise(matrix2);
console.log("\nRotated 90° counter-clockwise:");
printMatrix(matrix2);
// [[3, 6, 9], [2, 5, 8], [1, 4, 7]]

const matrix3 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
rotateMatrixLayerByLayer(matrix3);
console.log("\nLayer by layer rotation:");
printMatrix(matrix3);
// [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
