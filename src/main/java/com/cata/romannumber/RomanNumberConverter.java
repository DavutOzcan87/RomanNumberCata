package com.cata.romannumber;

import static com.cata.romannumber.OneDigitNumberConverter.of;
import static com.cata.romannumber.OneDigitNumberConverter.times;

/**
 * Created by davut on 21.03.2017.
 */
public class RomanNumberConverter {


    OneDigitNumberConverter onesConverter = of("I" , "V" , "X");
    OneDigitNumberConverter tensConverter = of("X" , "L" , "C");
    OneDigitNumberConverter hundredsConverter = of("C" , "D" , "M");
    private final int value;

    public RomanNumberConverter(int value) {
        this.value = value;
    }

    public static String convert(int value)
    {
        return new RomanNumberConverter(value).convert();
    }

    private String convert()
    {
        int tens = (value % 100)/10;
        int ones = value %10;
        int hundreds = (value % 1000)/100;
        int thousands = (value % 10000) / 1000;
        if(thousands > 4)
            throw new IllegalArgumentException("Value cannot be higher than 4999");
        return times(thousands , "M")+
                hundredsConverter.convert(hundreds)+
                tensConverter.convert(tens) +
                onesConverter.convert(ones);
    }
}
