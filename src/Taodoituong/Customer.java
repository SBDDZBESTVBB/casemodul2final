package Taodoituong;

import Manager.ManagerAccount;
import Manager.ManagerBills;
import Manager.ManagerProducts;
import io.ReadAndWrite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Account implements Serializable {
    private String fullname;
    private String address;
    private int phonenumber;
    private ArrayList<Integer> bills = new ArrayList<Integer>();


    public Customer() {
        this.setRole("Customer");
        this.bills = new ArrayList<>();
    }

    public Customer(String username, String password, String fullname, String address, int phonenumber) {
        super(username, password);
        this.fullname = fullname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.setRole("Customer");
        this.bills = new ArrayList<>();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public ArrayList<Integer> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Integer> bills) {
        this.bills = bills;
    }

    public void muaHang(ManagerProducts managerProducts, ManagerBills managerBills, ManagerAccount managerAccount, ReadAndWrite readAndWrite) {

        Scanner scanner = new Scanner(System.in);
        Bills bills = new Bills();
        while (true) {
            managerProducts.Show();
            System.out.println("1. Chon mua hang theo id");
            System.out.println("2. Danh sach mat hang da chon");
            System.out.println("3. Sua danh sach mua hang");
            System.out.println("4. Xac nhan mua hang");
            System.out.println("5 . Thoat");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 5 || choice < 1) throw new Exception();
                    break;
                } catch (Exception e) {
                    System.out.println("Nhap sai roi, moi nhap lai");
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("1. Nhap id hang muon mua");
                    int id;
                    while (true) {
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Nhap sai roi, nhap lai di");
                        }
                    }
                    ;
                    Products products = managerProducts.findProductsbyid(id);
                    if (products == null) {
                        break;
                    } else {
                        while (true) {
                            System.out.println("2. Nhap so luong");
                            int amount;
                            while (true) {
                                try {
                                    amount = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Nhap sai roi, nhap lai di");
                                }
                            }
                            Products newproducts = new Products(products.getName(), products.getColor(), products.getPrice(), amount);
                            newproducts.setId(products.getId());
                            Products products2 = products;
                            if (products2.getAmount() - newproducts.getAmount() < 0)
                                System.out.println("Khong mua duoc qua so luong");
                            else {
                                bills.getProducts().add(newproducts);
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    for (Products p : bills.getProducts()
                    ) {
                        p.Show();
                    }
                    break;
                case 3:
                    System.out.println("Nhap id hang muon sua");
                    int id1;
                    while (true) {
                        try {
                            id1 = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Nhap sai roi, nhap lai di");
                        }
                    }
                    ;
                    int num = bills.findProductbyId(id1);
                    Products products1 = managerProducts.findProductsbyid(id1);
                    if (num == -1) {
                        System.out.println(" Chua co mat hang nay trong gio hang cua ban");
                        break;
                    } else {
                        bills.getProducts().get(num).Show();
                        System.out.println("1. Xoa");
                        System.out.println("2. Sua so luong");
                        System.out.println("3. Thoat");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1) {
                            case 1:
                                bills.getProducts().remove(num);
                                break;
                            case 2:
                                while (true) {
                                    System.out.println("Nhap so luong muon thay doi");
                                    int count = 0;
                                    while (true) {
                                        try {
                                            count = Integer.parseInt(scanner.nextLine());
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Nhap sai roi, nhap lai di");
                                        }
                                    }
                                    if (count > products1.getAmount())
                                        System.out.println(" Khong mua dc so hang lon hon so luong hang hein co");
                                    else
                                        bills.getProducts().get(num).setAmount(count);
                                    break;
                                }
                                break;
                            case 3:
                                break;
                        }
                    }
                    break;
                case 4:
                    managerBills.addBills(bills);
                    this.bills.add(bills.getId());
                    bills.setIdcustomer(this.getId());
                    for (Products product : bills.getProducts()
                    ) {
                        Products products2 = managerProducts.findProductsbyid(product.getId());
                        products2.setAmount(products2.getAmount() - product.getAmount());
                    }
                    readAndWrite.write(managerBills.bills, "Bills.txt");
                    readAndWrite.write(managerProducts.products, "Products.txt");
                    readAndWrite.write(managerAccount.accounts, "Accounts.txt");
                    return;
                case 5:
                    return;
            }
        }

    }

    public void ktraBillhangdamua(ManagerBills managerBills) {
        for (int idbill : bills
        ) {
            managerBills.findBillbyid(idbill).Show();
        }

    }

    @Override
    public String toString() {
        return "Customer :" +
                "id : " + getId() +
                "fullname :" + fullname + '\'' +
                ", address :" + address + '\'' +
                ", phonenumber :" + phonenumber +
                ", bills:" + bills;
    }

    public void show() {
        System.out.printf("%-10s %-20s %-15s %-15s %-20s\n", getId(), getFullname(), getAddress(), getPhonenumber(), "ID bill:" + getBills());
    }
}
