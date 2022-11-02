import java.util.Random;
import java.util.Scanner;

/**
 * Request an integer value (n) from the user
 * Creates two nxn-matrices
 * Fills the matrices with random integer values (from 0 to 99)
 * Prints the two matrices to the console
 * <p>
 * Multiplies the matrices
 * Outputs the result of the multiplication to the console
 *
 * @author Enno Stassny
 * @version 1.0
 * @since 1.0
 */
public class Main
{
    public static void main(String args[])
    {
        // Get an integer value from the user through the console input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a integer: ");

        // Scan the entered integer and get the absolute
        int n = Math.abs(scanner.nextInt());

        /* Declaration  of two 2D matrices */
        int[][] firstMatrix = new int[n][n];
        int[][] secondMatrix = new int[n][n];

        // Fill matrices with random integers
        fill2DMatrixWithRandomIntegers(firstMatrix, 100);
        fill2DMatrixWithRandomIntegers(secondMatrix, 100);

        // Print the filled matrices to the console
        System.out.print("First matrix:");
        printMatrix(firstMatrix);
        System.out.println("\n");

        System.out.print("Second matrix:");
        printMatrix(secondMatrix);
        System.out.println("\n");

        // Multiplies the matrices
        int[][] multiplicationResultMatrix = multiplyTwoMatrices(firstMatrix, secondMatrix);
        System.out.print("Multiplication result matrix:");
        printMatrix(multiplicationResultMatrix);
        System.out.println("\n");
    }

    /**
     * This methode fills all fields of a 2D matrix with random integers
     *
     * @param matrix a 2D matrix
     * @param range the range of the random
     */
    private static void fill2DMatrixWithRandomIntegers(int[][] matrix, int range)
    {
        Random random = new Random();
        // Loop through the number of rows
        for (int i = 0; i < matrix.length; i++)
            // Loop through the number of columns
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = random.nextInt(range);
    }

    /**
     * Returns a 2D matrix that is the result of multiplying two matrices together
     * <p>
     * This methode multiplies two matrices with each other
     * Important: The matrices must be of the same amount of columns and rows
     *
     * @param firstMatrix  a 2D matrix
     * @param secondMatrix a 2D matrix
     * @return a new 2D matrix
     */
    public static int[][] multiplyTwoMatrices(int[][] firstMatrix, int[][] secondMatrix)
    {
        // Create a new matrix of the same size as the input matrices
        int[][] finalMatrix = new int[firstMatrix.length][secondMatrix[0].length];

        // Create counter values
        int row = 0;
        int column = 0;
        int row2 = 0;
        int fieldsFilled = 0;

        while (fieldsFilled != finalMatrix.length * secondMatrix[0].length)
        {
            // When the column reached the end increment the row and reset the column
            if (column == secondMatrix[0].length)
            {
                column = 0;
                row++;
            }
            // If the seconds row count is smaller than the length of the row: Calculate, increment the second row count
            if (row2 < firstMatrix.length)
            {
                finalMatrix[row][column] += firstMatrix[row][row2] * secondMatrix[row2][column];
                row2++;
                continue; // Go to the next iteration
            }

            // reset the second row count, increment the column and the fields filled count
            row2 = 0;
            column++;
            fieldsFilled++;
        }

        return finalMatrix;
    }

    /**
     * This methode prints a 2D matrix to the console
     *
     * @param matrix a 2D matrix
     */
    private static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) // Loop through the number of rows
        {
            System.out.print("\n"); //Print a new line for every row
            for (int j = 0; j < matrix[0].length; j++) // Loop through the number of columns
                // \t (Tabulator) aligns the columns
                System.out.print(matrix[i][j] + "\t"); //Print the value of the current field to the console
        }
    }
}
