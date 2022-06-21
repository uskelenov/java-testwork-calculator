package com.company;

public enum roman {
    I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"), VIII("8"), IX("9"), X("10");

    private final String number;

    roman (String number) {
        this.number = number;
    }

    String getSymbol() {
        return number;
    }
}