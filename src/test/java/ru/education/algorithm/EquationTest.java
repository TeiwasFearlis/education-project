package ru.education.algorithm;

import org.junit.jupiter.api.Test;
import ru.education.algorithm.twosum.StringEqNew;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EquationTest {

    

    @Test
    public void test1() {
        final StringEquation stringEquation = new StringEquation();
        ArrayList<Double> x = stringEquation.equationRegEx("-x^2 + x  = 0");
        assertTrue(Arrays.equals(x.toArray(),new Object[]{0.0,1.0}));
    }

    @Test
    public void test2() {
        final StringEqNew stringEquation = new StringEqNew();
        ArrayList<Double> doubles = stringEquation.equationRegEx("2x^2-32x=0");
        assertTrue(Arrays.equals(doubles.toArray(),new Object[]{0.0,16.0}));
    }

    @Test
    public void test3() {
        final StringEqNew stringEquation = new StringEqNew();
        ArrayList<Double> doubles = stringEquation.equationRegEx("1x^2 + 4x - 1.1 = 0");
        assertTrue(Arrays.equals(doubles.toArray(),new Object[]{0.2583179581272428, -4.258317958127243}));
    }


    @Test
    public void test4() {
        final StringEqNew stringEquation = new StringEqNew();
        ArrayList<Double> doubles = stringEquation.equationRegEx("x^2 + 2x + 1 = 0");
        assertTrue(Arrays.equals(doubles.toArray(),new Object[]{-1.0}));
    }

    @Test
    public void test5() {
        final StringEqNew stringEquation = new StringEqNew();
        ArrayList<Double> doubles = stringEquation.equationRegEx("1x^2 + x + 1 = 0");
        assertTrue(Arrays.equals(doubles.toArray(),new Object[]{-1.0}));
    }

    @Test
    public void test6() {
        final StringEqNew stringEquation = new StringEqNew();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> stringEquation.equationRegEx("1x^2 + x + 1 = 0"));
        assertEquals("the equation has no roots", exception.getMessage());
    }

    @Test
    public void test6_1() {
        final StringEqNew stringEquation = new StringEqNew();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> stringEquation.equationRegEx("1x^2 - x + 1 = 0"));
        assertEquals("the equation has no roots", exception.getMessage());
    }


    @Test
    public void test7() {
        final StringEqNew stringEquation = new StringEqNew();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> stringEquation.equationRegEx("0x^2 + x + 1 = 0"));
        assertEquals("Error a==0", exception.getMessage());
    }


    @Test
    public void test8() {
        final StringEqNew stringEquation = new StringEqNew();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> stringEquation.equationRegEx("x + x^2 = 0"));
        assertEquals("Pattern not found", exception.getMessage());
    }



}
