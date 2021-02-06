package ru.education.array;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayCalculateTest {

    @Test
    public void twoSumTest1() {

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1, 0, 50, -2, -60});
        assertTrue(Arrays.equals(calculate.twoSum(calculate.numbers, 50), new int[]{1, 2}));

    }

    @Test
    public void twoSumTest2() {

        ArrayCalculate calculate = new ArrayCalculate(new int[]{0, 50, 2, 60});
        assertFalse(Arrays.equals(calculate.twoSum(calculate.numbers, 60), new int[]{0, 1}));

    }
    @Test
    public void twoSumTest3(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1,2,7});
        assertFalse(calculate.twoSum(calculate.numbers, 0)!=null);

    }

    @Test
    public void twoSumTest4(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{});
        assertFalse(calculate.twoSum(calculate.numbers, 15)!=null);

    }


    @Test
    public void twoSumTest5(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1});
        assertFalse(calculate.twoSum(calculate.numbers, 15)!=null);

    }


    @Test
    public void twoSumTest6(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1,2});
        assertFalse(calculate.twoSum(calculate.numbers, 15)!=null);

    }

    @Test
    public void twoSumTest7() {

        ArrayCalculate calculate = new ArrayCalculate(new int[]{-1, 0, 2, 60, -50,34});
        assertTrue(Arrays.equals(calculate.twoSum(calculate.numbers, -48), new int[]{2, 4}));

    }




    @Test
    public void anotherTwoSum1() {

        ArrayCalculate calculate = new ArrayCalculate(new int[]{0, 50, 2, 60});
        assertFalse(Arrays.equals(calculate.anotherTwoSum(calculate.numbers, 60), new int[]{0, 1}));

    }
    @Test
    public void anotherTwoSum2() {

        ArrayCalculate calculate = new ArrayCalculate(new int[]{-1, 0, 50, 2, 60});
        assertTrue(Arrays.equals(calculate.twoSum(calculate.numbers, 50), new int[]{1, 2}));

    }

    @Test
    public void anothertwoSumTest3(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1,2,7});
        assertFalse(calculate.anotherTwoSum(calculate.numbers, 0)!=null);

    }

    @Test
    public void anothertwoSumTest4(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{});
        assertFalse(calculate.anotherTwoSum(calculate.numbers, 15)!=null);

    }


    @Test
    public void anothertwoSumTest5(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1});
        assertFalse(calculate.anotherTwoSum(calculate.numbers, 15)!=null);

    }


    @Test
    public void anothertwoSumTest6(){

        ArrayCalculate calculate = new ArrayCalculate(new int[]{1,2});
        assertFalse(calculate.anotherTwoSum(calculate.numbers, 15)!=null);

    }
    @Test
    public void anothertwoSumTest7() {

        ArrayCalculate calculate = new ArrayCalculate(new int[]{-1, 0, 2, 60, -50,-34});
        assertTrue(Arrays.equals(calculate.anotherTwoSum(calculate.numbers, -48), new int[]{2, 4}));

    }

    @Test
    public void loadTest(){
        long start  = System.currentTimeMillis();//10
        ArrayCalculate calculate = new ArrayCalculate(new int[]{-1, 0, 2, 60, -50,-34});
        assertTrue(Arrays.equals(calculate.anotherTwoSum(calculate.numbers, -48), new int[]{2, 4}));
        System.out.println("Time executed:"+(System.currentTimeMillis()/*30*/-start/*10*/));
    }

    @Test
    public void loadTest2(){
        long start  = System.currentTimeMillis();//10
        ArrayCalculate calculate = new ArrayCalculate(new int[]{-1, 0, 2, 60, -50,-34});
        assertTrue(Arrays.equals(calculate.twoSum(calculate.numbers, -48), new int[]{2, 4}));
        System.out.println("Time executed:"+(System.currentTimeMillis()/*30*/-start/*10*/));
    }



}