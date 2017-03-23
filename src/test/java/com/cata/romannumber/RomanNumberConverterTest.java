package com.cata.romannumber;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static com.cata.romannumber.RomanNumberConverter.convert;
/**
 * Created by davut on 21.03.2017.
 */
public class RomanNumberConverterTest
{
    @Test
    public void shouldConvert_1()
    {
        assertThat(convert(1) , is("I") );
    }

    @Test public void shouldConvert_2()
    {
        assertThat(convert(2), is("II"));
    }

    @Test public void shouldConvert_3()
    {
        assertThat(convert(3) , is("III"));
    }

    @Test public void shouldConvert_4()
    {
        assertThat(convert(4) , is("IV"));
    }

    @Test public void shouldConvertNumbersFrom_5to9()
    {
        assertThat(convert(5) , is("V"));
        assertThat(convert(6) , is("VI"));
        assertThat(convert(7) , is("VII"));
        assertThat(convert(8) , is("VIII"));
        assertThat(convert(9) , is("IX"));
    }
    
    @Test public void shouldConvertTens()
    {
        assertThat(convert(10) , is("X"));
        assertThat(convert(20) , is("XX"));
        assertThat(convert(30) , is("XXX"));
        assertThat(convert(40) , is("XL"));
        assertThat(convert(50) , is("L"));
        assertThat(convert(60) , is("LX"));
        assertThat(convert(70) , is("LXX"));
        assertThat(convert(80) , is("LXXX"));
        assertThat(convert(90) , is("XC"));
    }
    
    @Test public void shouldConvertHundreds()
    {
       assertThat(convert(100) , is("C"));
       assertThat(convert(200) , is("CC"));
       assertThat(convert(300) , is("CCC"));
       assertThat(convert(400) , is("CD"));
       assertThat(convert(500) , is("D"));
       assertThat(convert(600) , is("DC"));
       assertThat(convert(700) , is("DCC"));
       assertThat(convert(800) , is("DCCC"));
       assertThat(convert(900) , is("CM"));
    }

    @Test public void shouldConvertCustomCases()
    {
        assertThat(convert(111) , is("CXI"));
        assertThat(convert(222) , is("CCXXII"));
        assertThat(convert(333) , is("CCCXXXIII"));
        assertThat(convert(444) , is("CDXLIV"));
        assertThat(convert(555) , is("DLV"));
        assertThat(convert(666) , is("DCLXVI"));
        assertThat(convert(777) , is("DCCLXXVII"));
        assertThat(convert(888) , is("DCCCLXXXVIII"));
        assertThat(convert(999) , is("CMXCIX"));
    }

    @Test public void shouldConvertThousands()
    {
        assertThat(convert(1000) , is("M"));
        assertThat(convert(2000) , is("MM"));
        assertThat(convert(3000) , is("MMM"));
        assertThat(convert(4000) , is("MMMM"));
    }
    
    @Test public void shouldConvert_4999()
    {
        assertThat(convert(4999), is("MMMMCMXCIX"));
    }
    
    @Test(expected = Exception.class)
    public void shouldNotConvertNumbersLargerThan4999()
    {
        convert(5000);
    }
}
