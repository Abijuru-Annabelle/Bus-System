import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {
    
    public static String getValidString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
            } else {
                break;
            }
        }
        return input;
    }

    public static int getValidInt(Scanner scanner, String prompt) {
        int input = 0;
        while (true) {
            System.out.print(prompt);
            String strInput = scanner.nextLine().trim();
            try {
                input = Integer.parseInt(strInput);
                if (input < 0) {
                    System.out.println("Error: Number cannot be negative. Please enter a positive number.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid format. Please enter a valid whole number.");
            }
        }
        return input;
    }

    public static double getValidDouble(Scanner scanner, String prompt) {
        double input = 0.0;
        while (true) {
            System.out.print(prompt);
            String strInput = scanner.nextLine().trim();
            try {
                input = Double.parseDouble(strInput);
                if (input < 0) {
                    System.out.println("Error: Number cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid format. Please enter a valid decimal number.");
            }
        }
        return input;
    }

    public static String getValidPhoneNumber(Scanner scanner, String prompt) {
        String phoneRegex = "^\\d{10}$"; // Assuming 10 digit phone number format
        Pattern pattern = Pattern.compile(phoneRegex);
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Error: Invalid phone number format. Please enter 10 digits (e.g., 1234567890).");
            }
        }
        return input;
    }

    public static String getValidEmail(Scanner scanner, String prompt) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Error: Invalid email format. Please enter a valid email address.");
            }
        }
        return input;
    }
}
