package com.cata.romannumber;

/**
 * Created by davut on 23.03.2017.
 */
class OneDigitNumberConverter {
    final String lower;
    final String mid;
    final String higher;

    private OneDigitNumberConverter(String lower, String mid, String higher) {
        this.lower = lower;
        this.mid = mid;
        this.higher = higher;
    }

    public String convert(int value) {
        switch (value) {
            case 0:
                return "";
            case 1:
                return times(1, getLowerChar());
            case 2:
                return times(2, getLowerChar());
            case 3:
                return times(3, getLowerChar());
            case 4:
                return getLowerChar() + getMidChar();
            case 5:
                return getMidChar();
            case 6:
                return getMidChar() + getLowerChar();
            case 7:
                return getMidChar() + times(2, getLowerChar());
            case 8:
                return getMidChar() + times(3, getLowerChar());
            case 9:
                return getLowerChar() + getHigherChar();
        }
        throw new IllegalArgumentException("Only 0-9 numbers can be converted " + value);
    }

    public String getLowerChar() {
        return lower;
    }

    public String getMidChar() {
        return mid;
    }

    public String getHigherChar() {
        return higher;
    }

    public static String times(int count, String repetetive) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += repetetive;
        }
        return result;
    }

    public static OneDigitNumberConverter of(String lower, String mid, String higher) {
        return new OneDigitNumberConverter(lower, mid, higher);
    }
}
