package com.cata.romannumber;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by davut on 21.03.2017.
 */
public class RomanNumberConverterTest
{
    INumberConverter converter;

    @Before
    public void init()
    {
        //converter = o ->RomanNumberConverter.convert(o);
        converter = new RomanNumberConverterV2();
    }

    @Test
    public void shouldConvert_1()
    {
        assertThat(converter.convert(1) , is("I") );
    }

    @Test public void shouldConvert_2()
    {
        assertThat(converter.convert(2), is("II"));
    }

    @Test public void shouldConvert_3()
    {
        assertThat(converter.convert(3) , is("III"));
    }

    @Test public void shouldConvert_4()
    {
        assertThat(converter.convert(4) , is("IV"));
    }

    @Test public void shouldConvertNumbersFrom_5to9()
    {
        assertThat(converter.convert(5) , is("V"));
        assertThat(converter.convert(6) , is("VI"));
        assertThat(converter.convert(7) , is("VII"));
        assertThat(converter.convert(8) , is("VIII"));
        assertThat(converter.convert(9) , is("IX"));
    }
    
    @Test public void shouldConvertTens()
    {
        assertThat(converter.convert(10) , is("X"));
        assertThat(converter.convert(20) , is("XX"));
        assertThat(converter.convert(30) , is("XXX"));
        assertThat(converter.convert(40) , is("XL"));
        assertThat(converter.convert(50) , is("L"));
        assertThat(converter.convert(60) , is("LX"));
        assertThat(converter.convert(70) , is("LXX"));
        assertThat(converter.convert(80) , is("LXXX"));
        assertThat(converter.convert(90) , is("XC"));
    }
    
    @Test public void shouldConvertHundreds()
    {
       assertThat(converter.convert(100) , is("C"));
       assertThat(converter.convert(200) , is("CC"));
       assertThat(converter.convert(300) , is("CCC"));
       assertThat(converter.convert(400) , is("CD"));
       assertThat(converter.convert(500) , is("D"));
       assertThat(converter.convert(600) , is("DC"));
       assertThat(converter.convert(700) , is("DCC"));
       assertThat(converter.convert(800) , is("DCCC"));
       assertThat(converter.convert(900) , is("CM"));
    }

    @Test public void shouldConvertCustomCases()
    {
        assertThat(converter.convert(111) , is("CXI"));
        assertThat(converter.convert(222) , is("CCXXII"));
        assertThat(converter.convert(333) , is("CCCXXXIII"));
        assertThat(converter.convert(444) , is("CDXLIV"));
        assertThat(converter.convert(555) , is("DLV"));
        assertThat(converter.convert(666) , is("DCLXVI"));
        assertThat(converter.convert(777) , is("DCCLXXVII"));
        assertThat(converter.convert(888) , is("DCCCLXXXVIII"));
        assertThat(converter.convert(999) , is("CMXCIX"));
    }

    @Test public void shouldConvertThousands()
    {
        assertThat(converter.convert(1000) , is("M"));
        assertThat(converter.convert(2000) , is("MM"));
        assertThat(converter.convert(3000) , is("MMM"));
        assertThat(converter.convert(4000) , is("MMMM"));
    }
    
    @Test public void shouldConvert_4999()
    {
        assertThat(converter.convert(4999), is("MMMMCMXCIX"));
    }
    
    @Test(expected = Exception.class)
    public void shouldNotConvertNumbersLargerThan4999()
    {
        converter.convert(5000);
    }
}
