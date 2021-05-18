package ru.education.algorithm;

import org.junit.jupiter.api.Test;
import ru.education.algorithm.twosum.StringEqNew;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EquationTest {


    String str3 = "x^2 + 2x + 1 = 0";
    String str4 = "1x^2 + x + 1 = 0";
    String str5 = "0x^2 + x + 1 = 0";


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


}
