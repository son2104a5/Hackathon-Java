package ra.entity;

import ra.validate.Validator;

import java.util.Scanner;

public class Customer extends Validator implements IApp {
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {
    }

    public Customer(String customerId, String firstName, String lastName, String dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        this.customerId = validateCustomerRegex(sc, "Nhập ID", "[C]\\d{4}");
        this.firstName = validateString(sc, "Nhập tên đầu", 50, 0);
        this.lastName = validateString(sc, "Nhập tên cuối", 30, 0);
        this.dateOfBirth = validateCustomerRegex(sc, "Nhập ngày sinh(dd/mm/yyyy)", "d{2}+/+d{2}+/+d{4}");
        System.out.print("Nhập giới tính(true - Nam, false - Nữ): ");
        this.gender = Boolean.parseBoolean(sc.nextLine());
        this.address = validateString(sc, "Nhập địa chỉ", 255, 0);
        this.phoneNumber = validateCustomerRegex(sc, "Nhập SĐT", "[097|036|094]\\d{7}");
        System.out.print("Nhập email: ");
        this.email = sc.nextLine();
        System.out.print("Nhập loại khách hàng: ");
        this.customerType = sc.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("ID khách hàng: %s - Tên khách hàng: %s - Ngày sinh: %s - Giới tính: %s\n" +
                "Địa chỉ: %s\n" +
                "Số điện thoại: %s - Email: %s\n" +
                "Loại khách hàng: %s\n", this.customerId, this.firstName + " " + this.lastName, this.dateOfBirth, this.gender ? "Nam" : "Nữ", this.address, this.phoneNumber, this.email, this.customerType);
    }
}
