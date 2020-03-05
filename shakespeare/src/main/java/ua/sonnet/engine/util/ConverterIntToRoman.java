package ua.sonnet.engine.util;

public class ConverterIntToRoman {
    public static String intToRoman(int number) {
        String[] romanThousands = {"", "M", "MM", "MMM"};
        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanOnes = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String resultThousand = romanThousands[number / 1000];
        String resultHundred = romanHundreds[(number % 1000) / 100];
        String resultTen = romanTens[(number % 100) / 10];
        String resultOnes = romanOnes[number % 10];

        return resultThousand + resultHundred + resultTen + resultOnes;
    }
}
