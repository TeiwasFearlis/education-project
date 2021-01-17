package HomeWork;

import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals("cba",calculate.sumLetter());
    }

    @Test
    public void middleLatter() {
        StringCalculate calculate = new StringCalculate(new String[]{"a","b","c"});
        assertEquals("b",calculate.sumLetter());
    }

    @Test
    public void maxSizeString() {
        StringCalculate calculate = new StringCalculate(new String[]{"a","ba","c"});
        assertEquals("ba",calculate.sumLetter());
    }
}