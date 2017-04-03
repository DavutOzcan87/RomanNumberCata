package com.cata.romannumber;

/**
 * Created by davut on 04.04.2017.
 */
public class RomanNumberConverterV2 implements INumberConverter {
    private static final char [] ROMAN_NUMBERS = {'I','V','X','L','C','D','M'};

    private StringBuilder buffer;
    private int romanNumberIndex;

    @Override
    public String convert(int arg)
    {

        this.romanNumberIndex = 0;
        String result = "";
        for (int i = 0; i < 3; i++)
        {
            buffer = new StringBuilder();
            int mod = arg % 10;
            appendNumber(mod);
            this.romanNumberIndex+=2;
            result= buffer.toString() + result;

            arg = arg/10;
            if(arg == 0)
                return result;
        }
        if(arg!= 0)
            result = thousandValueOf(arg%10) + result;
        return result;
    }

    private String thousandValueOf(int arg)
    {
        if(arg > 4)
            throw new IllegalArgumentException("only 0-4999 supported");
        String result = "";
        for (int i = 0; i < arg; i++) {
            result+='M';
        }
        return result;
    }

    private void appendNumber(int mod)
    {
        if(mod <= 3)
        {
            appendUsingIndex(this.romanNumberIndex,mod);
        }else if(mod == 4)
        {
            appendUsingIndex(this.romanNumberIndex , 1);
            appendUsingIndex(this.romanNumberIndex+1 , 1);
        }else if(mod <= 8)
        {
            appendUsingIndex(this.romanNumberIndex+1 , 1);
            appendUsingIndex(this.romanNumberIndex , mod - 5);
        }else if(mod == 9)
        {
            appendUsingIndex(this.romanNumberIndex , 1);
            appendUsingIndex(this.romanNumberIndex+2 , 1);
        }else
            throw new IllegalArgumentException("Only 0-9 numbers accepted");
    }

    private void appendUsingIndex(int romanNumberIndex , int count) {
        for (int i = 0; i < count; i++) {
            buffer.append(ROMAN_NUMBERS[romanNumberIndex]);
        }
    }
}
