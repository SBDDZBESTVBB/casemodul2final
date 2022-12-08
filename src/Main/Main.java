package Main;

import Manager.ManagerAccount;
import Manager.ManagerBills;
import Manager.ManagerCustomer;
import Manager.ManagerProducts;
import Menu.MenuAdmin;
import Menu.MenuCustomer;
import Taodoituong.Account;
import Taodoituong.Admin;
import Taodoituong.Customer;
import io.ReadAndWrite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerAccount managerAccount = new ManagerAccount();
        ManagerProducts managerProducts = new ManagerProducts();
        ManagerCustomer managerCustomer = new ManagerCustomer();
        ManagerBills managerBills = new ManagerBills();
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuCustomer menuCustomer = new MenuCustomer();
        ReadAndWrite readAndWrite = new ReadAndWrite();
        managerAccount.accounts = readAndWrite.read("Accounts.txt");
        managerProducts.products = readAndWrite.read("Products.txt");
        managerBills.bills = readAndWrite.read("Bills.txt");
        managerAccount.addAccount();
        readAndWrite.write(managerAccount.accounts, "Accounts.txt");
        for (Account a : managerAccount.accounts
        ) {
            if (a instanceof Customer) {
                Customer customer = (Customer) a;
                managerCustomer.customers.add(customer);
            }
        }
        while (true) {
            System.out.println(" 1. Dang nhap");
            System.out.println(" 2. Dang ky");
            System.out.println(" 3. Thoat chuong trinh");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 3 || choice < 1) throw new Exception();
                    break;
                } catch (Exception e) {
                    System.out.println(" Nhap sai roi, moi nhap lai");
                }

            }
            switch (choice) {
                case 1:
                    Account account = managerAccount.login();
                    if (account instanceof Admin) {

                        menuAdmin.menuAdmin(managerCustomer, managerBills, managerProducts,managerAccount, readAndWrite);

                    }
                    if (account instanceof Customer) {
                        Customer customer = (Customer) account;

                        menuCustomer.menuCustomer(customer, managerProducts, managerBills,managerAccount, readAndWrite);

                    }
                    if (account == null) System.out.println("Nhap sai username hoac password");

                    break;
                case 2:
                    managerCustomer.dangky(managerAccount,readAndWrite);
                    readAndWrite.write(managerAccount.accounts, "Accounts.txt");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
