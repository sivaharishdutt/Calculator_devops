
package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        do {
            System.out.println("Choose one operation for devops tool implementation");
            System.out.print("Enter 1 to find factorial\nEnter 2 to find Square root\nEnter 3 to find power\nEnter 4 to find natural logarithm\n" +
                    "Enter 5 to exit\nPlease Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // do factorial
                    System.out.print("Please Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("The Factorial of "+num1+" is : " + calculator.factorial(num1));
                    System.out.println("\n");

                    break;
                case 2:
                    // find square root
                    System.out.print("Please Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("Square root of "+num1+" is : " + calculator.sqroot(num1));
                    System.out.println("\n");


                    break;
                case 3:
                    // find power
                    System.out.print("Please Enter the first number : ");
                    num1 = scanner.nextDouble();
                    System.out.print("Please Enter the second number : ");
                    num2 = scanner.nextDouble();
                    System.out.println(num1+ " raised to the power of"+num2+" is : " + calculator.power(num1, num2));
                    System.out.println("\n");
                    System.out.println("\n");
                    break;
                case 4:
                    // find natural log
                    System.out.print("Please Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("The Natural log of "+num1+" is : " + calculator.naturalLog(num1));
                    System.out.println("\n");
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Now Exiting....");
                    return;
            }
        } while (true);
    }


    public double factorial(double number1) {
        logger.info("[FACTORIAL] - " + number1);
        double result = fact(number1);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }



    public double sqroot(double number1) {
        logger.info("[SQ ROOT] - " + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }


    public double power(double number1, double number2) {
        logger.info("[POWER - " + number1 + " RAISED TO] " + number2);
        double result = Math.pow(number1,number2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double number1) {
        logger.info("[NATURAL LOG] - " + number1);
        double result = 0;
        try {

            if (number1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
             else {
                result = Math.log(number1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Enter a positive number, Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
    public double fact(double num) {
        double factorial = 1;
        for(int i = 1; i <= num; i++)
        { factorial =factorial * i;   }
        return  factorial;
    }
}