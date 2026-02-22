package e_commerce;

public class Product {

    String name;
    String company;
    String ram;
    String storage;
    String color;
    double price;

    public Product(String name, String company, String ram, String storage, String color, double price) {
        this.name = name;
        this.company = company;
        this.ram = ram;
        this.storage = storage;
        this.color = color;
        this.price = price;
    }

    public void displayRow(int index) {
        System.out.printf("%-4d %-30s %-15s %-8s %-10s %-12s ₹%-8.2f\n",
                index, name, company, ram, storage, color, price);
    }

}

