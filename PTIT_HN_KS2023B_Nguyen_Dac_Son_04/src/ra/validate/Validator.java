package ra.validate;

import ra.entity.Customer;

import java.util.Scanner;

public class Validator {
    public static String validateString(Scanner scanner, String message, int maxLength, int minLength) {
        do {
            System.out.print(message + ": ");
            String value = scanner.nextLine();
            if (value.length() > maxLength || value.length() < minLength) {
                System.err.println("Độ dài chuỗi không nằm trong phạm vi, vui lòng nhập lại.");
            } else {
                return value;
            }
        } while (true);
    }

    public static String validateCustomerRegex(Scanner scanner, String message, String regex) {
        do {
            System.out.print(message + ": ");
            String value = scanner.nextLine();
            if (value.matches(regex)) {
                System.err.println("Không đúng định dạng, vui lòng nhập lại.");
            } else {
                return value;
            }
        } while (true);
    }
}
