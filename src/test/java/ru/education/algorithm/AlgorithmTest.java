package ru.education.algorithm;


import org.junit.jupiter.api.Test;
import ru.education.algorithm.twosum.Algorithm;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgorithmTest {

   final Algorithm algorithm = new Algorithm();

    @Test
    public void twoSumToFix() {
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }

    @Test
    public void twoSumTest1() {
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{1, 0, 50, -2, -60}, 50), new int[]{1, 2}));
    }

    @Test
    public void twoSumTest2() {
        assertFalse(Arrays.equals(algorithm.twoSum(new int[]{0, 50, 2, 60}, 60), new int[]{0, 1}));
    }

    @Test
    public void twoSumTest3(){
        assertFalse(algorithm.twoSum(new int[]{1,2,7}, 0)!=null);
    }

    @Test
    public void twoSumTest4(){
        assertFalse(algorithm.twoSum(new int[]{}, 15)!=null);
    }


    @Test
    public void twoSumTest5(){
        assertFalse(algorithm.twoSum(new int[]{1}, 15)!=null);
    }


    @Test
    public void twoSumTest6(){
        assertFalse(algorithm.twoSum(new int[]{1,2}, 15)!=null);
    }

    @Test
    public void twoSumTest7() {
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{-1, 0, 2, 60, -50,34}, -48), new int[]{2, 4}));
    }


    @Test
    public void twoSumTest8() {
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{0, 0}, 0), new int[]{0, 1}));
    }




    @Test
    public void anotherTwoSumToFix() {
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }


    @Test
    public void anotherTwoSum1() {
        assertFalse(Arrays.equals(algorithm.anotherTwoSum(new int[]{0, 50, 2, 60}, 60), new int[]{0, 1}));
    }

    @Test
    public void anotherTwoSum2() {
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{-1, 0, 50, 2, 60}, 50), new int[]{1, 2}));
    }

    @Test
    public void anothertwoSumTest3(){
        assertFalse(algorithm.anotherTwoSum(new int[]{1,2,7}, 0)!=null);
    }

    @Test
    public void anothertwoSumTest4(){
        assertFalse(algorithm.anotherTwoSum(new int[]{}, 15)!=null);
    }


    @Test
    public void anothertwoSumTest5(){
        assertFalse(algorithm.anotherTwoSum(new int[]{1}, 15)!=null);

    }


    @Test
    public void anothertwoSumTest6(){
        assertFalse(algorithm.anotherTwoSum(new int[]{1,2}, 15)!=null);
    }
    @Test
    public void anothertwoSumTest7() {
        assertTrue(Arrays.equals(algorithm.anotherTwoSum(new int[]{-1, 0, 2, 60, -50,-34}, -48), new int[]{2, 4}));
    }


    @Test
    public void anothertwoSumTest8() {
        assertTrue(Arrays.equals(algorithm.anotherTwoSum(new int[]{0, 0}, 0), new int[]{0, 1}));
    }

    @Test
    public void loadTest(){
        long start  = System.currentTimeMillis();//10
        assertTrue(Arrays.equals(algorithm.anotherTwoSum(new int[]{-1, 0, 2, 60, -50,-34}, -48), new int[]{2, 4}));
        System.out.println("Time executed:"+(System.currentTimeMillis()/*30*/-start/*10*/));
    }

    @Test
    public void loadTest2(){
        long start  = System.currentTimeMillis();//10
        assertTrue(Arrays.equals(algorithm.twoSum(new int[]{-1, 0, 2, 60, -50,-34}, -48), new int[]{2, 4}));
        System.out.println("Time executed:"+(System.currentTimeMillis()/*30*/-start/*10*/));
    }




}