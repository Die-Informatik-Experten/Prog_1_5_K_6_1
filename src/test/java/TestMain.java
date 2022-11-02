/*
 * Project : Prog_1_5_K_6_1
 * Author  : Enno
 * Date    : 02.11.2022
 * Time    : 21:15
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain
{
    @Test
    void test2x2MatricesMultiplicationAssertTrue()
    {
        int[][] matrixOne = {{2,2},{2,2}};
        int[][] matrixTwo = {{4,4},{4,4}};
        int[][] result = Main.multiplyTwoMatrices(matrixOne, matrixTwo);
        int[][] assume = {{16,16},{16,16}};
        assertTrue(Arrays.deepEquals(result, assume));
    }
}
