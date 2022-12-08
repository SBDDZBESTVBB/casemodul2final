package Manager;

import Taodoituong.Customer;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerCustomer {
    public ArrayList<Customer> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void dangky(ManagerAccount managerAccount, ReadAndWrite readAndWrite) {
        String username, password;
        while (true) {
            System.out.println("Nhap user name");
            username = scanner.nextLine();
            boolean username1 = Pattern.matches("[a-z0-9A-Z]{6,12}", username);
            if (username1) break;
            else System.out.println("Username tu 6-12 kytu va ko co ky tu dac biet");
        }
        while (true) {
            System.out.println("Nhap pass word");
            password = scanner.nextLine();
            boolean username1 = Pattern.matches("[a-z0-9A-Z]{6,12}", password);
            if (username1) break;
            else System.out.println("Username tu 6-12 kytu va ko co ky tu dac biet");
        }
        if (managerAccount.ktrausername(username)) {
            System.out.println("Nhap fullname");
            String fullname = scanner.nextLine();
            System.out.println("Nhap address");
            String address = scanner.nextLine();
            System.out.println("Nhap so dien thoai");
            int sdt = Integer.parseInt(scanner.nextLine());
            Customer customer = new Customer(username, password, fullname, address, sdt);
            customer.setId(managerAccount.accounts.get(managerAccount.accounts.size() - 1).getId() + 1);
            customers.add(customer);
            managerAccount.accounts.add(customer);
            readAndWrite.write(managerAccount.accounts, "Accounts.txt");
        } else {
            System.out.println("Tai khoan da ton tai");
            return;
        }
    }

    public void deleteByid(ManagerAccount managerAccount, ReadAndWrite readAndWrite) {
        System.out.println("Nhap id khach hang can xoa");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhap sai du lieu moi nhap lai");
            }
        }
        for (Customer c : customers
        ) {
            if (c.getId() == id) {
                customers.remove(c);
                managerAccount.accounts.remove(c);
            }

        }
        readAndWrite.write(managerAccount.accounts,"Accounts.txt");

    }

    @Override
    public String toString() {
        String x = "";
        for (Customer c : this.customers
        ) {
            x = x + c.toString() + "\n";
        }
        return x;
    }
}
