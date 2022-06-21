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
            throw new InputException("throws Exception //т.к. пустая строка");
        }

        // work with enter the String
        String mathExample = new String(input);

        if ( mathExample.length() < 3 ) {
            throw new InputException("throws Exception //т.к. строка не является математической операцией");
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
            if ( count == 1 ) {
                searchOperator = operators.ADD.getSymbol();
            } else if ( count > 1 ) {
                throw new InputException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                throw new InputException("throws Exception //т.к. строка не является математической операцией");
            }
        } else if ( mathExample.contains( operators.SUBTRACT.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.SUBTRACT.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.SUBTRACT.getSymbol();
            } else if ( count > 1 ) {
                throw new InputException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                throw new InputException("throws Exception //т.к. строка не является математической операцией");
            }
        } else if ( mathExample.contains( operators.MULTIPLY.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.MULTIPLY.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.MULTIPLY.getSymbol();
            } else if ( count > 1 ) {
                throw new InputException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                throw new InputException("throws Exception //т.к. строка не является математической операцией");
            }
        } else if ( mathExample.contains( operators.DIVIDE.getSymbol() ) ) {
            for ( char element : mathExample.toCharArray() ) {
                if ( element == operators.DIVIDE.getSymbol().charAt(0) ) {
                    count++;
                }
            }
            if ( count == 1) {
                searchOperator = operators.DIVIDE.getSymbol();
            } else if ( count > 1 ) {
                throw new InputException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                throw new InputException("throws Exception //т.к. строка не является математической операцией");
            }
        } else {
            throw new InputException("throws Exception //т.к. строка не является математической операцией");
        }

        // operands search
        String firstOperand = mathExample.substring(0, mathExample.indexOf(searchOperator) );
        String secondOperand = mathExample.substring( mathExample.indexOf(searchOperator) + 1);

        for ( roman symbolRoman : roman.values() )  {
            if ( firstOperand.equals(symbolRoman.toString()) ) {
                firstOperand = symbolRoman.name();
            }

            if ( secondOperand.equals(symbolRoman.toString()) ) {
                secondOperand = symbolRoman.name();
            }
        }

        // number system check
        Checks Check = new Checks();
        if ( Check.isNumeric(firstOperand) != Check.isNumeric(secondOperand)
        || Check.isNumeric(firstOperand) != Check.isNumeric(secondOperand) ) {
            throw new InputException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        
        // getting a result
        String strResult;
        int result;
        int fistRomanOperator = 0;
        int secondRomanOperator = 0;

        switch ( searchOperator ) {
            case "+":

                // roman result of ADD
                if ( Check.isNumeric(firstOperand) == false) {
                    for ( roman symbolRoman : roman.values()) {
                        if ( firstOperand == symbolRoman.name() ) {
                            fistRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }

                        if ( secondOperand == symbolRoman.name() ) {
                            secondRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }
                    }

                    if (fistRomanOperator == 0 || secondRomanOperator == 0) {
                        throw new InputException("throws Exception //т.к. используются одновременно разные системы счисления");
                    }

                    result = fistRomanOperator + secondRomanOperator;
                    strResult = String.valueOf(result);

                    switchRoman switchRoman = new switchRoman();
                    strResult = switchRoman.numRoman(strResult);
                }

                // arabic result of ADD
                else {
                    if ( Integer.parseInt(firstOperand) > 10 || Integer.parseInt(firstOperand) <= 0
                    || Integer.parseInt(secondOperand) > 10 || Integer.parseInt(secondOperand) <= 0 ) {
                        throw new InputException("throws Exception //т.к. на вход принимаются только числа от 1 до 10 и от I до X включительно");
                    }

                    result = Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand);
                    strResult = String.valueOf(result);
                }
                break;

            case "-":

                // roman SUBTRACT result
                if ( Check.isNumeric(firstOperand) == false) {
                    for ( roman symbolRoman : roman.values()) {
                        if ( firstOperand == symbolRoman.name() ) {
                            fistRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }

                        if ( secondOperand == symbolRoman.name() ) {
                            secondRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }
                    }

                    if (fistRomanOperator == 0 || secondRomanOperator == 0) {
                        throw new InputException("throws Exception //т.к. используются одновременно разные системы счисления");
                    }

                    result = fistRomanOperator - secondRomanOperator;

                    if ( result < 0 ) {
                        throw new InputException("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    }

                    strResult = String.valueOf(result);

                    switchRoman switchRoman = new switchRoman();
                    strResult = switchRoman.numRoman(strResult);
                }

                // arabic SUBTRACT result
                else {
                    if ( Integer.parseInt(firstOperand) > 10 || Integer.parseInt(firstOperand) <= 0
                            || Integer.parseInt(secondOperand) > 10 || Integer.parseInt(secondOperand) <= 0 ) {
                        throw new InputException("throws Exception //т.к. на вход принимаются только числа от 1 до 10 и от I до X включительно");
                    }

                    result = Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand);
                    strResult = String.valueOf(result);
                }
                break;

            case "*":

                // roman result MULTIPLY
                if ( Check.isNumeric(firstOperand) == false) {
                    for ( roman symbolRoman : roman.values() ) {
                        if ( firstOperand == symbolRoman.name() ) {
                            fistRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }

                        if ( secondOperand == symbolRoman.name() ) {
                            secondRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }
                    }

                    if (fistRomanOperator == 0 || secondRomanOperator == 0) {
                        throw new InputException("throws Exception //т.к. используются одновременно разные системы счисления");
                    }

                    result = fistRomanOperator * secondRomanOperator;
                    strResult = String.valueOf(result);

                    switchRoman switchRoman = new switchRoman();
                    strResult = switchRoman.numRoman(strResult);
                }

                // arabic result MULTIPLY
                else {
                    if ( Integer.parseInt(firstOperand) > 10 || Integer.parseInt(firstOperand) <= 0
                            || Integer.parseInt(secondOperand) > 10 || Integer.parseInt(secondOperand) <= 0 ) {
                        throw new InputException("throws Exception //т.к. на вход принимаются только числа от 1 до 10 и от I до X включительно");
                    }

                    result = Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand);
                    strResult = String.valueOf(result);
                }
                break;

            case "/":

                // roman DIVIDE result
                if ( Check.isNumeric(firstOperand) == false) {
                    for ( roman symbolRoman : roman.values()) {
                        if ( firstOperand == symbolRoman.name() ) {
                            fistRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }

                        if ( secondOperand == symbolRoman.name() ) {
                            secondRomanOperator = Integer.parseInt(symbolRoman.getSymbol());
                        }
                    }

                    if (fistRomanOperator == 0 || secondRomanOperator == 0) {
                        throw new InputException("throws Exception //т.к. используются одновременно разные системы счисления");
                    }

                    result = fistRomanOperator / secondRomanOperator;
                    strResult = String.valueOf(result);

                    switchRoman switchRoman = new switchRoman();
                    strResult = switchRoman.numRoman(strResult);
                }

                // arabic DIVIDE result
                else {
                    if (Integer.parseInt(secondOperand) == 0) {
                        throw new InputException("throws Exception //т.к. делить на 0 нельзя");
                    }

                    if ( Integer.parseInt(firstOperand) > 10 || Integer.parseInt(firstOperand) <= 0
                            || Integer.parseInt(secondOperand) > 10 || Integer.parseInt(secondOperand) <= 0 ) {
                        throw new InputException("throws Exception //т.к. на вход принимаются только числа от 1 до 10 и от I до X включительно");
                    }

                    result = Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand);
                    strResult = String.valueOf(result);
                }
                break;
            default:
                throw new InputException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        return "The result of your math example: " + strResult;

    }

}

class InputException extends Exception {

    public InputException( String message ) {

        super( message );
    }

}

class Checks {

    boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

class switchRoman {

    String numRoman (String str) {
        for ( romanResult symbolRoman : romanResult.values() ) {
            if ( str.equals(symbolRoman.getSymbol()) ) {
                str = symbolRoman.name();
            }
        }
       return str;
    }

}