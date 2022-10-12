import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean check1 = false;
        boolean check2 = false;
        System.out.println("List of operations: add, subtract, multiply, divide, and alphabetize.");
        System.out.print("Enter an operation:\n");
        String operation = input.next();
        switch (operation.toLowerCase()) {
            case "add":
                System.out.print("Enter two integers:\n");
                check1 = input.hasNextInt();
                if (check1) {
                    int add1 = input.nextInt();
                    check2 = input.hasNextInt();
                    if (check2) {
                        int add2 = input.nextInt();
                        int addition = add1 + add2;
                        System.out.println("Answer: " + addition);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            case "subtract":
                System.out.print("Enter two integers:\n");
                check1 = input.hasNextInt();
                if (check1) {
                    int sub1 = input.nextInt();
                    check2 = input.hasNextInt();
                    if (check2) {
                        int sub2 = input.nextInt();
                        int subtraction = sub1 - sub2;
                        System.out.println("Answer: " + subtraction);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            case "multiply":
                System.out.print("Enter two doubles:\n");
                check1 = input.hasNextDouble();
                if (check1) {
                    double mult1 = input.nextDouble();
                    check2 = input.hasNextDouble();
                    if (check2) {
                        double mult2 = input.nextDouble();
                        double multiplication = mult1 * mult2;
                        System.out.printf("Answer: %.2f\n", multiplication);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            case "divide":
                System.out.print("Enter two doubles:\n");
                check1 = input.hasNextDouble();
                if (check1) {
                    double div1 = input.nextDouble();
                    check2 = input.hasNextDouble();
                    if (check2) {
                        double div2 = input.nextDouble();
                        if (div2 == 0) {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                        double division = div1 / div2;
                        System.out.printf("Answer: %.2f\n", division);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            case "alphabetize":
                System.out.print("Enter two words:\n");
                check1 = input.hasNext();
                if (check1) {
                    String word1 = input.next();
                    check2 = input.hasNext();
                    if (check2) {
                        String word2 = input.next();
                        int order = word1.compareToIgnoreCase(word2);
                        if (order > 0) {
                            System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                        }
                        else if (order < 0) {
                            System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                        }
                        else if (order == 0) {
                            System.out.println("Answer: Chicken or Egg.");
                        }
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }        
    }
}
