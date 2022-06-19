package com.company;

public enum operators {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String symbol;

    operators (String symbol) {
        this.symbol = symbol;
    }

    String getSymbol() {
        return symbol;
    }
}

