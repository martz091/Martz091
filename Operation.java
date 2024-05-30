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
            System.out.print("Enter the operation (+, -, *, %): ");
            operation = scanner.next();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equals("%")) {
                validInput = true;
            } else {
                System.out.println("Error: Invalid operation. Please enter a valid operation (+, -, *, /, %).");
            }
            scanner.close();
        }

        // Perform the specified operation
       