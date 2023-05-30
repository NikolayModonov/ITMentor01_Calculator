package main.java;

import java.util.Scanner;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        String messageInfo = "This is Calculator App\n" +
                "Calculator works with integers from 1 to 10\n" +
                "Calculator can do 4 operations: + - * /\n" +
                "Example of input: 6 + 5";
        String input;

        System.out.println(messageInfo);
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
        System.out.println("Press Enter to exit");
        scanner.nextLine();
    }

    public static String calc(String input){
        String messageWrongInput = "Input string is wrong.";
        String messageWrongOperands = "Operands is wrong.";
        String messageWrongOperation = "Operation is wrong.";
        String messageWrongDivisionByZero = "Division by zero is unacceptable.";

        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException(messageWrongInput);
        }

        int operand1;
        int operand2;
        try {
            operand1 = Integer.parseInt(tokens[0]);
            operand2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(messageWrongOperands);
        }
        if ((operand1 < 1) || (operand1 > 10) || (operand2 < 1) || (operand2 > 10)) {
            throw new IllegalArgumentException(messageWrongOperands);
        }

        int result;
        switch (tokens[1]) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException(messageWrongDivisionByZero);
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException(messageWrongOperation);
        }

        return String.valueOf(result);
    }
}
