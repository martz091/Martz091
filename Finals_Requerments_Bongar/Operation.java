import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A calculator program that takes two numbers and an operation as input
 * and performs the specified operation.
 */
public class Operation {
	 /**
     * The main method that runs the calculator program.
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger num1 = null;
        BigInteger num2 = null;
        String operation = null;
        boolean runProgram = true;

        while (runProgram) {
            // Loop until valid input is received for the first number
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter the first number: ");
                try {
                    num1 = scanner.nextBigInteger();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input. Please enter a valid number.");
                    scanner.next(); // consume the invalid input
                }
            }

            // Loop until valid input is received for the second number
            validInput = false;
            while (!validInput) {
                System.out.print("Enter the second number: ");
                try {
                    num2 = scanner.nextBigInteger();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input. Please enter a valid number.");
                    scanner.next(); // consume the invalid input
                }
            }

            // Loop until valid input is received for the operation
            validInput = false;
            while (!validInput) {
                System.out.print("Enter the operation (+, -, *, /, %): ");
                operation = scanner.next();
                if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equals("%")) {
                    validInput = true;
                } else {
                    System.out.println("Error: Invalid operation. Please enter a valid operation (+, -, *, /, %).");
                }
            }

            // Perform the specified operation
            BigInteger result = null;
            switch (operation) {
                case "+":
                    result = num1.add(num2);
                    break;
                case "-":
                    result = num1.subtract(num2);
                    break;
                case "*":
                    result = num1.multiply(num2);
                    break;
                case "/":
                    if (num2.equals(BigInteger.ZERO)) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        BigInteger quotient = num1.divide(num2);
                        System.out.println("Quotient: " + quotient);
                    }
                    break;
                case "%":
                    if (num2.equals(BigInteger.ZERO)) {
                        System.out.println("Error: Remainder by zero is not allowed.");
                    } else {
                        BigInteger remainder = num1.remainder(num2);
                        System.out.println("Remainder: " + remainder);
                    }
                    break;
            }

            if (result!= null) {
                System.out.println("Result: " + result);
            }

            // Ask the user if they want to reset the program or end it
            System.out.print("Do you want to reset the program? (y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("y")) {
                // Reset the program
                System.out.println("Program reset.");
            } else if (response.equalsIgnoreCase("n")) {
                // End the program
                System.out.println("Program ended.");
                runProgram = false;
            } else {
                System.out.println("Invalid input. Please enter y or n.");
            }
        }
    }
}
