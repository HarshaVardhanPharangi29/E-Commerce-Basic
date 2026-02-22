package e_commerce;

public class Cart {

    Product[] items;   // Array to store cart products
    int count = 0;

    // Constructor
    public Cart(int size) {
        items = new Product[size];
    }

    // Add product to cart
    public void addToCart(Product p) {
        if (count < items.length) {
            items[count] = p;
            count++;
            System.out.println(p.name + " added to cart successfully!");
        } else {
            System.out.println("Cart is full!");
        }
    }

    // Display cart items and total
    public void displayCart() {
    	System.out.println(Colors.GREEN + "=========== YOUR CART ===========" + Colors.RESET);
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + items[i].name + " - ₹" + items[i].price);
            total += items[i].price;
        }

        System.out.println("--------------------------------");
        System.out.println("Total Amount: ₹" + total);
        System.out.println("================================");
    }

    // Return total price
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].price;
        }
        return total;
    }

    // Check if cart is empty
    public boolean isEmpty() {
        return count == 0;
    }
}

