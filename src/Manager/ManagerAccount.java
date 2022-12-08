package Manager;

import Taodoituong.Account;
import Taodoituong.Admin;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    public ArrayList<Account> accounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addAccount() {
        if (accounts.size() == 0) {
            Admin admin = new Admin("Admin", "Admin");
            accounts.add(admin);
        }
    }

    public boolean ktrausername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) return false;
        }
        return true;
    }

    public Account login() {
        System.out.println("Nhap user name");
        String username = scanner.nextLine();
        System.out.println("Nhap password");
        String password = scanner.nextLine();
        for (Account acc : accounts
        ) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password))
                return acc;

            }
        System.out.println(" sai ten dang nhap hoac mat khau");
        return null;
        }

    }


