package Menu;

import Manager.ManagerAccount;
import Manager.ManagerBills;
import Manager.ManagerCustomer;
import Manager.ManagerProducts;
import Taodoituong.Customer;
import io.ReadAndWrite;

import java.util.Scanner;

public class MenuCustomer {
    Scanner scanner = new Scanner(System.in);

    public void menuCustomer(Customer customer, ManagerProducts managerProducts, ManagerBills managerBills, ManagerAccount managerAccount, ReadAndWrite readAndWrite) {
        while (true) {
            System.out.println("Xin chao " + customer.getFullname());
            System.out.println(" 1. Mua hang ");
            System.out.println(" 2. Kiem tra bill hang da mua");
            System.out.println(" 3 . Doi mat khau");
            System.out.println("4. Thay doi thong tin ca nhan");
            System.out.println("5. Dang xuat");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 5 || choice < 1) throw new RuntimeException();
                    break;
                } catch (Exception e) {
                    System.out.println(" Nhap sai roi nhap lai di");
                }
            }
            switch (choice) {
                case 1:
                    customer.muaHang(managerProducts, managerBills, managerAccount ,readAndWrite);
                    break;
                case 2:
                    customer.ktraBillhangdamua(managerBills);
                    break;
                case 3:
                    System.out.println("Nhap mat khau moi");
                    String newpassword = scanner.nextLine();
                    customer.setPassword(newpassword);
                    break;
                case 4:
                    System.out.println(" Nhap ten moi");
                    String name = scanner.nextLine();
                    System.out.println(" Nhap so dien thoai moi");
                    int phone;
                    while (true) {
                        try {
                            phone = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Nhap sai du lieu moi nhap lai");
                        }

                    }
                    System.out.println(" Nhap dia chi giao hang moi ");
                    String address = scanner.nextLine();
                    customer.setFullname(name);
                    customer.setAddress(address);
                    customer.setPhonenumber(phone);
                    break;
                case 5:
                    return;

            }
        }
    }


}
