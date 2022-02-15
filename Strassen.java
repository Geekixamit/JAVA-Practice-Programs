// Java Program to Implement Strassen Algorithm using recursion

// Class Strassen matrix multiplication
public class Strassen {
    
    // Function to multiply matrices
    public int[][] multiplyMatrix(int[][] A, int[][] B)
    {
        // get size of matrix
        int n = A.length;

        // Creating a 2D square matrix with size n
        int[][] R = new int[n][n];

        // Base case
        // If there is only single element
        if (n == 1)

            // Returning the simple multiplication of two elements in matrices
            R[0][0] = A[0][0] * B[0][0];

        // Matrix
        else 
        {
            // Step 1: Dividing Matrix into parts by storing sub-parts to variables
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            // Step 2: Dividing matrix A into 4 halves
            splitMatrix(A, A11, 0, 0);
            splitMatrix(A, A12, 0, n / 2);
            splitMatrix(A, A21, n / 2, 0);
            splitMatrix(A, A22, n / 2, n / 2);

            // Step 2: Dividing matrix B into 4 halves
            splitMatrix(B, B11, 0, 0);
            splitMatrix(B, B12, 0, n / 2);
            splitMatrix(B, B21, n / 2, 0);
            splitMatrix(B, B22, n / 2, n / 2);

            // Using Formulas as described in algorithm

            // M1:=(A1+A3)×(B1+B2)
            int[][] M1 = multiplyMatrix(addMatrix(A11, A22), addMatrix(B11, B22));
        
            // M2:=(A2+A4)×(B3+B4)
            int[][] M2 = multiplyMatrix(addMatrix(A21, A22), B11);
        
            // M3:=(A1−A4)×(B1+A4)
            int[][] M3 = multiplyMatrix(A11, subMatrix(B12, B22));
        
            // M4:=A1×(B2−B4)
            int[][] M4 = multiplyMatrix(A22, subMatrix(B21, B11));
        
            // M5:=(A3+A4)×(B1)
            int[][] M5 = multiplyMatrix(addMatrix(A11, A12), B22);
        
            // M6:=(A1+A2)×(B4)
            int[][] M6 = multiplyMatrix(subMatrix(A21, A11), addMatrix(B11, B12));
        
            // M7:=A4×(B3−B1)
            int[][] M7 = multiplyMatrix(subMatrix(A12, A22), addMatrix(B21, B22));

            // P:=M2+M3−M6−M7
            int[][] C11 = addMatrix(subMatrix(addMatrix(M1, M4), M5), M7);
        
            // Q:=M4+M6
            int[][] C12 = addMatrix(M3, M5);
        
            // R:=M5+M7
            int[][] C21 = addMatrix(M2, M4);
        
            // S:=M1−M3−M4−M5
            int[][] C22 = addMatrix(subMatrix(addMatrix(M1, M3), M2), M6);

            // Step 3: Join 4 halves into one result matrix
            joinMatrix(C11, R, 0, 0);
            joinMatrix(C12, R, 0, n / 2);
            joinMatrix(C21, R, n / 2, 0);
            joinMatrix(C22, R, n / 2, n / 2);
        }

        // Step 4: Return result
        return R;
    }

    // Function to subtract two matrices
    public int[][] subMatrix(int[][] A, int[][] B)
    {
        // get size 
        int n = A.length;

        // Creating a 2D square matrix
        int[][] C = new int[n][n];

        // Iterating over elements of 2D matrix using nested for loops
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                // Subtracting corresponding elements from matrices
                C[i][j] = A[i][j] - B[i][j];
        // Returning the resultant matrix
        return C;
    }

    // Function to add two matrices
    public int[][] addMatrix(int[][] A, int[][] B)
    {
        // get size
        int n = A.length;

        // Creating a 2D square matrix
        int[][] C = new int[n][n];

        // Iterating over elements of 2D matrix using nested for loops
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                // Adding corresponding elements of matrices
                C[i][j] = A[i][j] + B[i][j];
        // Returning the resultant matrix
        return C;
    }

    // Function to split parent matrix into child matrices
    public void splitMatrix(int[][] P, int[][] C, int iB, int jB)
    {
        // Iterating over elements of 2D matrix using nested for loops
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }

    // Function to join child matrices into parent matrix
    public void joinMatrix(int[][] C, int[][] P, int iB, int jB)
    {
        // Iterating over elements of 2D matrix using nested for loops
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }

    // Strassen driver method
    public static void main(String[] args)
    {
        // Create an object of Strassen class in he main function
        Strassen s = new Strassen();
        
        // Considering size as 4 in order to illustrate
        int N = 4;

        // Custom input to matrix A
        int[][] A = {{ 1, 1, 1, 1 },
                    { 2, 1, 2, 1 },
                    { 1, 2, 1, 2 },
                    { 2, 2, 2, 2 }};

        // Custom input to matrix B
        int[][] B = {{ 1, 1, 1, 1 },
                    { 2, 1, 2, 1 },
                    { 1, 2, 1, 2 },
                    { 2, 2, 2, 2 }};

        // Calling recursive function to find Matrix C
        int[][] C = s.multiplyMatrix(A, B);

        // Display Result
        System.out.println("### Product of matrices A and B using Strassen Multiplication Algorithm ###");

        // Run two nested for loops to display Result Matrix
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++)
            {
                System.out.printf("%-5d", C[i][j]);
            }
            System.out.println();
        }
    }
}