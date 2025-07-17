import java.util.*;

public class calculatorexception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter two numbers: ");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            
            System.out.print("Choose operation (+ - * /): ");
            char op = sc.next().charAt(0);
            
            double result = 0;
            switch (op) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/': 
                    if (b == 0) throw new ArithmeticException("Division by zero.");
                    result = a / b; break;
                default: throw new InputMismatchException("Invalid operation.");
            }
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
