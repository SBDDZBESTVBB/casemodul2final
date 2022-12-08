package Taodoituong;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bills implements Serializable {
    private ArrayList<Products> products;
    private LocalDate date;

    private String status;
    private int id;
    private int idcustomer;

    public Bills() {
        this.date = LocalDate.now();
        this.products = new ArrayList<Products>();
    }

    public Bills(ArrayList<Products> products, LocalDate date, String status) {
        this.products = products;
        this.date = date;
        this.status = status;
        this.date = LocalDate.now();
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdcustomer() {
        return idcustomer;
    }
    public double getSumofbills(){
        double sum = 0;
        for (Products p: products
             ) {
            sum = sum + p.getPrice()*p.getAmount();
        }
        return sum;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public int  findProductbyId(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id) return i;
        }return -1;
    }
public void Show(){
    System.out.printf("idbill:%-10s idcustomer:%-20s date:%-20s\n",id,idcustomer,date);
    for (Products p: products
         ) {
        p.Show();
    }
}
    @Override
    public String toString() {
        return "Bills{" +
                "products=" + products +
                ", date=" + date +
                ", sumbill=" + this.getSumofbills() +
                ", status='" + status + '\'' +
                ", id=" + id +
                ", idcustomer=" + idcustomer +
                '}';
    }
}
