package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String messageInfo = "This is Calculator App\n" +
                "Calculator works with integers from 1 to 10\n" +
                "Calculator can do 4 operations: + - * /\n" +
                "Example of input: 6 + 5\n" +
                "Write 'info' for this message or 'exit' for exit";
        String input;

        boolean exit = false;
        Scanner scanner;

        System.out.println(messageInfo);
        while (exit != true) {
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            input = input.trim();
            switch (input) {
                case "exit":
                    exit = true;
                    break;
                case "info":
                    System.out.println(messageInfo);
                    break;
                default:
                    System.out.println(calc(input));
            }
            System.out.println();
        }
    }

    public static String calc(String input){
        String messageWrongInput = "Your input is wrong.";
        String messageWrongOperands = "Your operands is wrong.";
        String messageWrongOperation = "Your operation is wrong.";
        String messageWrongDivisionByZero = "Division by zero is unacceptable.";

        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            return messageWrongInput;
        }

        int operand1;
        int operand2;
        try {
            operand1 = Integer.parseInt(tokens[0]);
            operand2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            return messageWrongOperands;
        }
        if ((operand1 < 1) || (operand1 > 10) || (operand2 < 1) || (operand2 > 10)) {
            return messageWrongOperands;
        }

        double result;
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
                    return messageWrongDivisionByZero;
                }
                result = operand1 / operand2;
                break;
            default:
                return messageWrongOperation;
        }

        return String.valueOf(result);
    }
}
