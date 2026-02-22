package e_commerce;

public class SubCategory {

    String name;
    Product[] products;   
    int count = 0;

    public SubCategory(String name, int size) {
        this.name = name;
        products = new Product[size];
    }

    public void addProduct(Product p) {
        if (count < products.length) {
            products[count] = p;
            count++;
        }
    }

    public void displayProducts() {
    	System.out.println(Colors.YELLOW + "\nSubCategory: " + name + Colors.RESET);
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-30s %-15s %-8s %-10s %-12s %-10s\n",
                "No", "Name", "Company", "RAM", "Storage", "Color", "Price");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            products[i].displayRow(i + 1);
        }
        System.out.println("----------------------------------------------------------------------------------------------");

    }

    public Product getProduct(int index) {
        if (index >= 0 && index < count) {
            return products[index];
        }
        return null;
    }
}

