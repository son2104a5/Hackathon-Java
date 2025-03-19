package ra.presentation;

import ra.entity.Customer;
import ra.validate.Validator;

import java.util.Scanner;

public class CustomerApplication extends Validator {
    private static int currentCustomerHas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer[] customers = new Customer[100];
        int updateChoice = 0;
        do {
            System.out.println("----------------------------Customer Menu----------------------------\n" +
                    "1. Hiển thị danh sách các khách hàng\n" +
                    "2. Thêm mới khách hàng\n" +
                    "3. Chỉnh sửa thông tin khách hàng\n" +
                    "4. Xóa khách hàng\n" +
                    "5. Tìm kiếm khách hàng\n" +
                    "6. Sắp xếp\n" +
                    "0. Thoát chương trình\n" +
                    " ------------------------------------------------------------------------");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayCustomers(customers);
                    break;
                case 2:
                    addCustomer(sc, customers);
                    break;
                case 3:
                    updateCustomer(sc, customers, updateChoice);
                    break;
                case 4:
                    deleteCustomer(sc, customers);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void displayCustomers(Customer[] customers) {
        if (currentCustomerHas == 0) {
            System.err.println("Danh sách trống.");
        } else {
            System.out.println("Danh sách các khách hàng hiện có:");
            for (int i = 0; i < currentCustomerHas; i++) {
                System.out.println("-----------------------------------------");
                customers[i].displayData();
                System.out.println("-----------------------------------------");
            }
        }
    }

    public static void addCustomer(Scanner sc, Customer[] customers) {
        System.out.print("Nhập số khách hàng muốn thêm: ");
        int numberCustomerAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberCustomerAdd; i++) {
            currentCustomerHas++;
            customers[currentCustomerHas - 1].inputData(sc);
        }
        System.out.println("Đã thêm " + numberCustomerAdd + " khách hàng vào danh sách.");
    }

    public static void updateCustomer(Scanner sc, Customer[] customers, int updateChoice) {
        System.out.println("Danh sách ID những khách hàng hiện tại:");
        for (int i = 0; i < currentCustomerHas; i++) {
            System.out.printf("%d. %s\n", i + 1, customers[i].getCustomerId());
        }
        System.out.println("Nhập ID khách hàng muốn cập nhât: ");
        String id = sc.nextLine();
        for (int i = 0; i < currentCustomerHas; i++) {
            if (customers[i].getCustomerId().contains(id)) {
                do {
                    System.out.println("Bạn muốn cập nhật thông tin nào:\n" +
                            "1. ID\n" +
                            "2. Tên\n" +
                            "3. Ngày sinh" +
                            "4. Giới tính" +
                            "5. Địa chỉ\n" +
                            "6. Số điện thoại\n" +
                            "7. Email\n" +
                            "8. Loại khách hàng\n" +
                            "0. Thoát");
                    System.out.print("Chọn chức năng: ");
                    updateChoice = Integer.parseInt(sc.nextLine());
                    switch (updateChoice) {
                        case 1:
                            String newIdValue = validateCustomerRegex(sc, "Nhập ID mới", "[C]\\d{4}");
                            customers[i].setCustomerId(newIdValue);
                            break;
                        case 2:
                            String newFirstName = validateString(sc, "Nhập tên đầu", 50, 0);
                            String newLastName = validateString(sc, "Nhập tên cuối", 30, 0);
                            customers[i].setFirstName(newFirstName);
                            customers[i].setLastName(newLastName);
                            break;
                        case 3:
                            String newDOBValue = validateCustomerRegex(sc, "Nhập ngày sinh(dd/mm/yyyy)", "d{2}+/+d{2}+/+d{4}");
                            customers[i].setDateOfBirth(newDOBValue);
                            break;
                        case 4:
                            boolean newGender = Boolean.parseBoolean(sc.nextLine());
                            customers[i].setGender(newGender);
                            break;
                        case 5:
                            String newAddress = validateString(sc, "Nhập địa chỉ", 255, 0);
                            customers[i].setAddress(newAddress);
                            break;
                        case 6:
                            String newPhoneNumber = validateCustomerRegex(sc, "Nhập SĐT", "[097|036|094]\\d{7}");
                            customers[i].setPhoneNumber(newPhoneNumber);
                            break;
                        case 7:
                            String newCustomerType = sc.nextLine();
                            customers[i].setCustomerType(newCustomerType);
                            break;
                        case 0:
                            System.out.println("Đã thoát chức năng.");
                            break;
                    }
                } while (updateChoice != 0);
                break;
            }
        }
        System.out.println("Khách hàng đã được cập nhật");
    }

    public static void deleteCustomer(Scanner sc, Customer[] customers) {
        System.out.println("Danh sách ID những khách hàng hiện tại:");
        for (int i = 0; i < currentCustomerHas; i++) {
            System.out.printf("%d. %s\n", i + 1, customers[i].getCustomerId());
        }
        System.out.println("Nhập ID khách hàng muốn xóa: ");
        String id = sc.nextLine();
        for (int i = 0; i < currentCustomerHas; i++) {
            if (customers[i].getCustomerId().contains(id)) {
                for (int j = i + 1; j < currentCustomerHas; j++) {
                    customers[i] = customers[j];
                }
                currentCustomerHas--;
                break;
            }
        }
    }
}