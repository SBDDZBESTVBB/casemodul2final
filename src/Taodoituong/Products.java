package Taodoituong;

import java.io.Serializable;

public class Products implements Serializable {
    private String name;
    private String color;
    private double price;
    private int amount;
    private int id;

    public Products() {
    }

    public Products(String name, String color, double price, int amount) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", id=" + id +
                '}';
    }
    public void Show(){
        System.out.printf("%-10d %-20s %-15s %-15f %-10d\n",id,name,color,price,amount);
    }
}
