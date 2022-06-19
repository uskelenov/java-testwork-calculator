package com.company;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        System.out.print( "Please enter your math example: " );

        try {
            System.out.println( calc( in.nextLine() ) );
        } catch ( InputException error ) {
            System.err.println( error.getMessage() );
        }
    }

    public static String calc(String input) throws InputException {
        input = input.replaceAll(" ", "");

        // empty check
        if ( input.isEmpty() ) {
            throw new InputException("throws Exception");
        }

        // work with enter the string
        String mathExample = new String(input);

        if ( mathExample.length() < 3 ) {
            throw new InputException("throws Exception");
        }

        // operator search
        String searchOperator;
        int count = 0;

        if ( mathExample.contains( operators.ADD.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.ADD.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.ADD.getSymbol();
            } else {
                throw new InputException("throws Exception");
            }

        } else if ( mathExample.contains( operators.SUBTRACT.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.SUBTRACT.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.SUBTRACT.getSymbol();
            } else {
                throw new InputException("throws Exception");
            }
        } else if ( mathExample.contains( operators.MULTIPLY.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.MULTIPLY.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.MULTIPLY.getSymbol();
            } else {
                throw new InputException("throws Exception");
            }
        } else if ( mathExample.contains( operators.DIVIDE.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.DIVIDE.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.DIVIDE.getSymbol();
            } else {
                throw new InputException("throws Exception");
            }
        } else {
            throw new InputException("throws Exception");
        }

        // operands search
        String firstOperand = mathExample.substring(0, mathExample.indexOf(searchOperator) );
        String secondOperand = mathExample.substring( mathExample.indexOf(searchOperator) + 1);

        if ( Integer.parseInt(firstOperand) > 10 || Integer.parseInt(firstOperand) <= 0
        || Integer.parseInt(secondOperand) > 10 || Integer.parseInt(secondOperand) <= 0 ) {
            throw new InputException("throws Exception");
        }

        // getting a result
        String strResult;
        int result;

        switch ( searchOperator ) {
            case "+":
                result = Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand);
                strResult = String.valueOf(result);
                break;

            case "-":
                result = Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand);
                strResult = String.valueOf(result);
                break;

            case "*":
                result = Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand);
                strResult = String.valueOf(result);
                break;

            case "/":
                if ( Integer.parseInt(secondOperand) == 0 ) {
                    throw new InputException("throws Exception");
                }

                result = Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand);
                strResult = String.valueOf(result);
                break;
            default:
                throw new InputException("throws Exception");
        }

        return "The result of your math example: " + strResult;
    }

}

class InputException extends Exception {

    public InputException( String message ) {
        super( message );
    }

}