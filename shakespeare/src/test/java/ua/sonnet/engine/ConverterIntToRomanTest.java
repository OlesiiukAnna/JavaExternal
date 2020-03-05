package ua.sonnet.engine;

import org.junit.jupiter.api.Test;
import ua.sonnet.engine.util.ConverterIntToRoman;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterIntToRomanTest {

    @Test
    void shouldReturnFive() {
        String actual = ConverterIntToRoman.intToRoman(5);

        String expected = "V";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEighteen(){
        String actual = ConverterIntToRoman.intToRoman(18);

        String expected = "XVIII";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTwentyNine(){
        String actual = ConverterIntToRoman.intToRoman(29);

        String expected = "XXIX";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFortyFour(){
        String actual = ConverterIntToRoman.intToRoman(44);

        String expected = "XLIV";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFiftyTwo(){
        String actual = ConverterIntToRoman.intToRoman(52);

        String expected = "LII";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSixtyEight(){
        String actual = ConverterIntToRoman.intToRoman(68);

        String expected = "LXVIII";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNinetyNine(){
        String actual = ConverterIntToRoman.intToRoman(99);

        String expected = "XCIX";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOneHundredTen(){
        String actual = ConverterIntToRoman.intToRoman(110);

        String expected = "CX";

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTwoThousand(){
        String actual = ConverterIntToRoman.intToRoman(2000);

        String expected = "MM";

        assertEquals(expected, actual);
    }
}