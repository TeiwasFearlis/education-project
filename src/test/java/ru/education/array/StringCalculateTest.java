package ru.education.array;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculateTest {
    @Test
    public void sumLetterSimple() {
        StringCalculate calculate = new StringCalculate(new String[]{"a","b","c"});
        assertEquals("abc",calculate.sumLetter());
    }

    @Test
    public void sumLetterOneElement() {
        StringCalculate calculate = new StringCalculate(new String[]{"a"});
        assertEquals("a",calculate.sumLetter());
    }

    @Test
    public void reversSumLetter() {
        StringCalculate calculate = new StringCalculate(new String[]{"a","b","c"});
        assertEquals("cba",calculate.reversSumLetter());
    }

    @Test
    public void middleLatter() {
        StringCalculate calculate = new StringCalculate(new String[]{"a","b","c"});
        assertEquals("b",calculate.middleLatter());
    }

    @Test
    public void maxSizeString() {
        StringCalculate calculate = new StringCalculate(new String[]{"a","ba","c"});
        assertEquals("ba",calculate.maxSizeString());
    }
    @Test
    public void maxSizeStringEmpty() {
        StringCalculate calculate = new StringCalculate(new String[]{""});
        assertEquals("",calculate.maxSizeString());
    }


}