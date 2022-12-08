package Menu;

import Manager.ManagerAccount;
import Manager.ManagerBills;
import Manager.ManagerCustomer;
import Manager.ManagerProducts;
import io.ReadAndWrite;

import java.util.Scanner;

public class MenuAdmin {
    Scanner scanner = new Scanner(System.in);

    public void menuAdmin(ManagerCustomer managerCustomer, ManagerBills managerBills, ManagerProducts managerProducts, ManagerAccount managerAccount, ReadAndWrite readAndWrite) {
        while (true) {
            System.out.println("1. Tong hop kho hang ton");
            System.out.println("2. Tong hop bills trong thang ");
            System.out.println("3. Tinh tong doanh thu trong thang");
            System.out.println("4. Hien thi tat ca khach hang");
            System.out.println("5. Xoa kh theo id");
            System.out.println("6. Them san pham");
            System.out.println("7. Sua san pham theo id ");
            System.out.println("8. Xoa san pham");
            System.out.println("9 . Thoat");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 9 || choice < 1) throw new Exception();
                    break;
                } catch (Exception e) {
                    System.out.println("Nhap sai roi, moi nhap lai");
                }
            }
            switch (choice) {
                case 1:
                    managerProducts.Show();
                    break;
                case 2:
                    managerBills.findBillinmoth();
                    break;
                case 3:
                    System.out.println("Tong doanh thu thang nay la: " + managerBills.sumBillinmonth());
                    break;
                case 4:
                    System.out.println(managerCustomer.toString());
                    break;
                case 5:
                    managerCustomer.deleteByid(managerAccount,readAndWrite);
                    break;
                case 6:
                    managerProducts.addProduct();
                    readAndWrite.write(managerProducts.products, "Products.txt");
                    break;
                case 7:
                    System.out.println(" Nhap id can sua");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhap so luong moi");
                    int newamount = Integer.parseInt(scanner.nextLine());
                    managerProducts.editProductbyid(id,newamount);
                    break;
                case 8:
                    managerProducts.deletebyId();
                    readAndWrite.write(managerProducts.products, "Products.txt");

                    break;
                case 9:
                    return;
            }
        }
    }
}
