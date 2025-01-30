import java.util.Scanner;

public class Calculator {
    private int num1;
    private int num2;

    public static enum Operators {
        add,
        subtract,
        multiply,
        divide,
        exit
    }

    // Constructor
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Getters
    public int getNum1() {
        return this.num1;
    }

    public int getNum2() {
        return this.num2;
    }

    // Setters
    public void setNumbers(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Perform operations based on the enum
    public int output(Operators operation) {
        switch (operation) {
            case add:
                return this.num1 + this.num2;
            case subtract:
                return this.num1 - this.num2;
            case multiply:
                return this.num1 * this.num2;
            case divide:
                if (this.num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return this.num1 / this.num2;
            case exit:
                System.out.println("Exiting...");
                return 0;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    public static void main(String[] args) {
        try {
            Operators operation;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Enter the numbers you want to calculate");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();

                System.out.println("Select the operation");
                System.out.println("1 : Add");
                System.out.println("2 : Subtract");
                System.out.println("3 : Multiply");
                System.out.println("4 : Divide");
                System.out.println("5 : Exit");

                int operation_id = scanner.nextInt();
                switch (operation_id) {
                    case (1):
                        operation = Operators.add;
                        break;
                    case (2):
                        operation = Operators.subtract;
                        break;
                    case (3):
                        operation = Operators.multiply;
                        break;
                    case (4):
                        operation = Operators.divide;
                        break;
                    case (5):
                        operation = Operators.exit;
                        break;
                    default:
                        System.out.println("You select invalid operator. So we will exit the programme");
                        operation = Operators.exit;
                        break;
                }
                Calculator calc = new Calculator(num1, num2);
                int output = calc.output(operation);
                System.out.print("your output is = ");
                System.out.println(output);

            } while (operation != Operators.exit);
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
