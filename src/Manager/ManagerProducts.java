package Manager;

import Taodoituong.Bills;
import Taodoituong.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProducts {
    public ArrayList<Products> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("Nhap ten mat hang");
        String name = scanner.nextLine();
        System.out.println("Nhap mau mat hang");
        String color = scanner.nextLine();
        System.out.println("Nhap gia tien");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap so luong");
        int amount = Integer.parseInt(scanner.nextLine());
        Products product = new Products(name, color, price, amount);
        if (products.size() == 0) {
            product.setId(1);
        } else {
            product.setId(products.get(products.size() - 1).getId() + 1);
        }
        products.add(product);
    }

    public Products findProductsbyname() {
        System.out.println("Nhap ten mat hang");
        String name = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name))
                System.out.println(products.get(i).toString());
            return products.get(i);
        }
        System.out.println(" Khong ton tai mat hang nay");
        return null;
    }

    public Products findProductsbyid(int num) {
        for (Products products : products
        ) {
            if (num == products.getId()) {
                products.Show();
                return products;
            }
        }
        System.out.println("khong co mat hang nay");
        return null;
    }

    public void Show() {
        System.out.printf("%-10s %-20s %-15s %-15s %-10s\n", "ID", "Ten san pham", "mau", "gia tien", "so luong");
        for (Products p : products) {
            p.Show();
        }
    }
    public void editProductbyid(int id, int newamount){
        this.findProductsbyid(id).setAmount(newamount);
    }

    @Override
    public String toString() {
        return "ManagerProducts{" +
                "products=" + products
                +
                '}';
    }

    public void deletebyId() {
        System.out.println("Nhap id san pham can xoa");
        int id = Integer.parseInt(scanner.nextLine());
        products.remove(findProductsbyid(id));
    }
}
