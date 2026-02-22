package e_commerce;

import java.util.Scanner;

public class ECommerceApp {

    static Category[] categories = new Category[5];
    static Cart cart = new Cart(50);
    static Payment payment = new Payment();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createCategories();
        showMainMenu();
    }

    // ---------------- MAIN MENU ----------------
    public static void showMainMenu() {
        while (true) {
        	System.out.println(Colors.CYAN + "\n========= E-COMMERCE APPLICATION =========" + Colors.RESET);
            System.out.println("1. Electronics");
            System.out.println("2. Fashion");
            System.out.println("3. Home Decor");
            System.out.println("4. Household");
            System.out.println("5. Stationery");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {
                showSubCategories(categories[choice - 1]);
            } else if (choice == 6) {
                checkout();
            } else if (choice == 7) {
                System.out.println("Thank you for shopping!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

 // ---------------- SUBCATEGORY MENU ----------------
    public static void showSubCategories(Category category) {
        category.displaySubCategories();
        System.out.print("Select SubCategory: ");
        int subChoice = sc.nextInt();

        SubCategory selectedSub = category.getSubCategory(subChoice - 1);
        if (selectedSub != null) {
            showProducts(selectedSub);
        } else {
            System.out.println("Invalid SubCategory!");
        }
    }

    // ---------------- PRODUCT MENU ----------------
    public static void showProducts(SubCategory subCategory) {
        subCategory.displayProducts();
        System.out.print("Select Product: ");
        int prodChoice = sc.nextInt();

        Product selectedProduct = subCategory.getProduct(prodChoice - 1);

        if (selectedProduct != null) {
            System.out.println("1. Add to Cart");
            System.out.println("2. Buy Now");
            System.out.print("Choose option: ");
            int option = sc.nextInt();

            if (option == 1) {
                cart.addToCart(selectedProduct);
            } else if (option == 2) {
                payment.makePayment(selectedProduct.price);
            } else {
                System.out.println("Invalid option!");
            }
        } else {
            System.out.println("Invalid Product!");
        }
    }

    // ---------------- CHECKOUT ----------------
    public static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        cart.displayCart();
        System.out.print("Proceed to payment? (1-Yes / 0-No): ");
        int ch = sc.nextInt();

        if (ch == 1) {
            payment.makePayment(cart.getTotal());
            System.out.println("Order placed successfully!");
        }
    }

    // Create all categories, subcategories and products
    public static void createCategories() {

        // 1. ELECTRONICS
    	// ELECTRONICS
    	Category electronics = new Category("Electronics", 4);

    	SubCategory mobiles = new SubCategory("Mobiles", 10);
    	mobiles.addProduct(new Product("Samsung Galaxy S24 Ultra", "Samsung", "12GB", "256GB", "Black", 124999));
    	mobiles.addProduct(new Product("iPhone 17 Pro Max", "Apple", "6GB", "256GB", "Purple", 129999));
    	mobiles.addProduct(new Product("OnePlus 11R", "OnePlus", "12GB", "256GB", "Blue", 44999));
    	mobiles.addProduct(new Product("Vivo X90 Pro", "Vivo", "12GB", "256GB", "Red", 84999));
    	mobiles.addProduct(new Product("Oppo Reno 10 Pro", "Oppo", "12GB", "256GB", "Gold", 39999));
    	mobiles.addProduct(new Product("Realme GT Neo 3", "Realme", "8GB", "128GB", "Black", 36999));
    	mobiles.addProduct(new Product("Xiaomi 13 Pro", "Xiaomi", "12GB", "256GB", "White", 79999));
    	mobiles.addProduct(new Product("iQOO Neo 7", "iQOO", "12GB", "256GB", "Orange", 34999));
    	mobiles.addProduct(new Product("Motorola Edge 40", "Motorola", "8GB", "128GB", "Green", 29999));
    	mobiles.addProduct(new Product("Samsung Galaxy A54", "Samsung", "8GB", "128GB", "Lime", 34999));

    	SubCategory laptops = new SubCategory("Laptops", 10);
    	laptops.addProduct(new Product("Dell Inspiron 15", "Dell", "16GB", "512GB", "Silver", 68000));
    	laptops.addProduct(new Product("HP Pavilion x360", "HP", "16GB", "1TB", "Grey", 74000));
    	laptops.addProduct(new Product("Lenovo IdeaPad Slim 5", "Lenovo", "16GB", "512GB", "Black", 65000));
    	laptops.addProduct(new Product("Apple MacBook Air M1", "Apple", "8GB", "256GB", "Gold", 92000));
    	laptops.addProduct(new Product("Asus VivoBook S15", "Asus", "16GB", "512GB", "Blue", 66000));
    	laptops.addProduct(new Product("Acer Aspire 7", "Acer", "16GB", "512GB", "Black", 62000));
    	laptops.addProduct(new Product("MSI Modern 14", "MSI", "16GB", "512GB", "Grey", 70000));
    	laptops.addProduct(new Product("Samsung Galaxy Book 2", "Samsung", "16GB", "512GB", "White", 78000));
    	laptops.addProduct(new Product("Realme Book Prime", "Realme", "8GB", "512GB", "Blue", 59000));
    	laptops.addProduct(new Product("HP Omen Gaming", "HP", "16GB", "1TB", "Black", 110000));

    	SubCategory headphones = new SubCategory("Headphones", 10);
    	headphones.addProduct(new Product("Sony WH-1000XM5", "Sony", "N/A", "N/A", "Black", 29999));
    	headphones.addProduct(new Product("Bose QuietComfort 45", "Bose", "N/A", "N/A", "White", 28999));
    	headphones.addProduct(new Product("JBL Tune 760NC", "JBL", "N/A", "N/A", "Blue", 12999));
    	headphones.addProduct(new Product("Boat Rockerz 550", "Boat", "N/A", "N/A", "Red", 1999));
    	headphones.addProduct(new Product("Sennheiser HD 450BT", "Sennheiser", "N/A", "N/A", "Black", 14999));
    	headphones.addProduct(new Product("Skullcandy Crusher", "Skullcandy", "N/A", "N/A", "Grey", 15999));
    	headphones.addProduct(new Product("OnePlus Buds Pro", "OnePlus", "N/A", "N/A", "White", 9999));
    	headphones.addProduct(new Product("Apple AirPods Pro", "Apple", "N/A", "N/A", "White", 24999));
    	headphones.addProduct(new Product("Realme Buds Air 3", "Realme", "N/A", "N/A", "Blue", 3999));
    	headphones.addProduct(new Product("Noise Cancelling Headset Pro", "Noise", "N/A", "N/A", "Black", 8999));

    	SubCategory powerbanks = new SubCategory("Power Banks", 10);
    	powerbanks.addProduct(new Product("Mi 20000mAh Power Bank", "Mi", "N/A", "20000mAh", "Black", 2199));
    	powerbanks.addProduct(new Product("Ambrane 10000mAh", "Ambrane", "N/A", "10000mAh", "White", 999));
    	powerbanks.addProduct(new Product("Realme 30W Dart Power Bank", "Realme", "N/A", "10000mAh", "Yellow", 2499));
    	powerbanks.addProduct(new Product("OnePlus 20000mAh", "OnePlus", "N/A", "20000mAh", "Red", 2999));
    	powerbanks.addProduct(new Product("Samsung 10000mAh Fast Charge", "Samsung", "N/A", "10000mAh", "Black", 1999));
    	powerbanks.addProduct(new Product("Boat EnergyShroom", "Boat", "N/A", "10000mAh", "Green", 1499));
    	powerbanks.addProduct(new Product("Syska 20000mAh", "Syska", "N/A", "20000mAh", "Blue", 1899));
    	powerbanks.addProduct(new Product("Portronics Power Brick", "Portronics", "N/A", "10000mAh", "Grey", 1299));
    	powerbanks.addProduct(new Product("Anker PowerCore", "Anker", "N/A", "10000mAh", "Black", 3499));
    	powerbanks.addProduct(new Product("Redmi 18W Power Bank", "Redmi", "N/A", "10000mAh", "White", 1699));

    	electronics.addSubCategory(mobiles);
    	electronics.addSubCategory(laptops);
    	electronics.addSubCategory(headphones);
    	electronics.addSubCategory(powerbanks);
    	categories[0] = electronics;


        // 2. FASHION
    	// FASHION
    	Category fashion = new Category("Fashion", 4);

    	SubCategory menWear = new SubCategory("Men Wear", 10);
    	menWear.addProduct(new Product("Peter England Formal Shirt", "Peter England", "N/A", "N/A", "White", 1599));
    	menWear.addProduct(new Product("Raymond Cotton Shirt", "Raymond", "N/A", "N/A", "Blue", 1799));
    	menWear.addProduct(new Product("Levi’s Slim Fit Jeans", "Levi's", "N/A", "N/A", "Dark Blue", 2499));
    	menWear.addProduct(new Product("Allen Solly Casual T-Shirt", "Allen Solly", "N/A", "N/A", "Black", 1299));
    	menWear.addProduct(new Product("Van Heusen Blazer", "Van Heusen", "N/A", "N/A", "Grey", 5999));
    	menWear.addProduct(new Product("Puma Sports Jacket", "Puma", "N/A", "N/A", "Red", 3499));
    	menWear.addProduct(new Product("Adidas Track Pants", "Adidas", "N/A", "N/A", "Navy Blue", 1999));
    	menWear.addProduct(new Product("U.S. Polo Assn T-Shirt", "US Polo", "N/A", "N/A", "Green", 1499));
    	menWear.addProduct(new Product("Louis Philippe Trousers", "Louis Philippe", "N/A", "N/A", "Black", 2999));
    	menWear.addProduct(new Product("Wrangler Denim Jeans", "Wrangler", "N/A", "N/A", "Light Blue", 2299));

    	SubCategory womenWear = new SubCategory("Women Wear", 10);
    	womenWear.addProduct(new Product("Biba Anarkali Kurti", "Biba", "N/A", "N/A", "Pink", 2499));
    	womenWear.addProduct(new Product("W for Women Palazzo Set", "W", "N/A", "N/A", "Yellow", 2799));
    	womenWear.addProduct(new Product("Aurelia Cotton Kurta", "Aurelia", "N/A", "N/A", "Blue", 1999));
    	womenWear.addProduct(new Product("Global Desi Maxi Dress", "Global Desi", "N/A", "N/A", "Red", 3499));
    	womenWear.addProduct(new Product("AND Western Top", "AND", "N/A", "N/A", "White", 1599));
    	womenWear.addProduct(new Product("Libas Ethnic Suit", "Libas", "N/A", "N/A", "Green", 2999));
    	womenWear.addProduct(new Product("FabIndia Silk Saree", "FabIndia", "N/A", "N/A", "Maroon", 4999));
    	womenWear.addProduct(new Product("Zivame Night Wear Set", "Zivame", "N/A", "N/A", "Purple", 1999));
    	womenWear.addProduct(new Product("Forever 21 Party Dress", "Forever21", "N/A", "N/A", "Black", 2599));
    	womenWear.addProduct(new Product("H&M Casual Top", "H&M", "N/A", "N/A", "Sky Blue", 1499));

    	SubCategory footwear = new SubCategory("Footwear", 10);
    	footwear.addProduct(new Product("Nike Running Shoes", "Nike", "N/A", "N/A", "Black", 4999));
    	footwear.addProduct(new Product("Adidas Sports Shoes", "Adidas", "N/A", "N/A", "White", 4599));
    	footwear.addProduct(new Product("Puma Sneakers", "Puma", "N/A", "N/A", "Red", 3999));
    	footwear.addProduct(new Product("Bata Formal Shoes", "Bata", "N/A", "N/A", "Brown", 2999));
    	footwear.addProduct(new Product("Woodland Leather Shoes", "Woodland", "N/A", "N/A", "Dark Brown", 5499));
    	footwear.addProduct(new Product("Red Tape Casual Shoes", "Red Tape", "N/A", "N/A", "Grey", 3499));
    	footwear.addProduct(new Product("Reebok Training Shoes", "Reebok", "N/A", "N/A", "Blue", 4299));
    	footwear.addProduct(new Product("Skechers Walking Shoes", "Skechers", "N/A", "N/A", "Navy", 5999));
    	footwear.addProduct(new Product("Campus Sports Shoes", "Campus", "N/A", "N/A", "Green", 1999));
    	footwear.addProduct(new Product("Liberty Sandals", "Liberty", "N/A", "N/A", "Black", 1499));

    	SubCategory watches = new SubCategory("Watches", 10);
    	watches.addProduct(new Product("Titan Analog Watch", "Titan", "N/A", "N/A", "Silver", 3499));
    	watches.addProduct(new Product("Fastrack Digital Watch", "Fastrack", "N/A", "N/A", "Black", 2499));
    	watches.addProduct(new Product("Casio G-Shock", "Casio", "N/A", "N/A", "Black", 8999));
    	watches.addProduct(new Product("Fossil Leather Watch", "Fossil", "N/A", "N/A", "Brown", 6999));
    	watches.addProduct(new Product("Sonata Classic Watch", "Sonata", "N/A", "N/A", "Gold", 1999));
    	watches.addProduct(new Product("Noise Smart Watch", "Noise", "N/A", "N/A", "Grey", 2999));
    	watches.addProduct(new Product("Boat Xtend Smart Watch", "Boat", "N/A", "N/A", "Blue", 2799));
    	watches.addProduct(new Product("Fire-Boltt Smart Watch", "Fire-Boltt", "N/A", "N/A", "Black", 2599));
    	watches.addProduct(new Product("Apple Watch Series 8", "Apple", "N/A", "N/A", "Red", 41999));
    	watches.addProduct(new Product("Samsung Galaxy Watch 4", "Samsung", "N/A", "N/A", "Green", 15999));

    	fashion.addSubCategory(menWear);
    	fashion.addSubCategory(womenWear);
    	fashion.addSubCategory(footwear);
    	fashion.addSubCategory(watches);
    	categories[1] = fashion;


        // 3. HOME DECOR
    	// HOME DECOR
    	Category homeDecor = new Category("Home Decor", 4);

    	SubCategory lights = new SubCategory("Lights", 10);
    	lights.addProduct(new Product("Philips LED Ceiling Light", "Philips", "N/A", "N/A", "White", 2499));
    	lights.addProduct(new Product("Wipro Smart LED Bulb", "Wipro", "N/A", "N/A", "Warm White", 999));
    	lights.addProduct(new Product("Syska Tube Light", "Syska", "N/A", "N/A", "Cool White", 799));
    	lights.addProduct(new Product("Havells Wall Lamp", "Havells", "N/A", "N/A", "Yellow", 1899));
    	lights.addProduct(new Product("Panasonic Night Lamp", "Panasonic", "N/A", "N/A", "Blue", 699));
    	lights.addProduct(new Product("Orient Decorative Light", "Orient", "N/A", "N/A", "Multi", 1499));
    	lights.addProduct(new Product("Bajaj LED Panel Light", "Bajaj", "N/A", "N/A", "White", 1999));
    	lights.addProduct(new Product("Crompton Chandelier", "Crompton", "N/A", "N/A", "Golden", 7999));
    	lights.addProduct(new Product("Mi Smart Bed Lamp", "Mi", "N/A", "N/A", "White", 2999));
    	lights.addProduct(new Product("Surya Table Lamp", "Surya", "N/A", "N/A", "Brown", 1299));

    	SubCategory curtains = new SubCategory("Curtains", 10);
    	curtains.addProduct(new Product("Home Centre Floral Curtain", "Home Centre", "N/A", "N/A", "Cream", 2499));
    	curtains.addProduct(new Product("Story@Home Blackout Curtain", "Story@Home", "N/A", "N/A", "Grey", 2799));
    	curtains.addProduct(new Product("Swayam Cotton Curtain", "Swayam", "N/A", "N/A", "Blue", 1999));
    	curtains.addProduct(new Product("Spaces Window Curtain", "Spaces", "N/A", "N/A", "Brown", 2299));
    	curtains.addProduct(new Product("D'Decor Designer Curtain", "D'Decor", "N/A", "N/A", "Maroon", 3499));
    	curtains.addProduct(new Product("Trident Sheer Curtain", "Trident", "N/A", "N/A", "White", 1799));
    	curtains.addProduct(new Product("Bombay Dyeing Curtain", "Bombay Dyeing", "N/A", "N/A", "Green", 2599));
    	curtains.addProduct(new Product("Portico New York Curtain", "Portico", "N/A", "N/A", "Purple", 2899));
    	curtains.addProduct(new Product("Hometown Printed Curtain", "Hometown", "N/A", "N/A", "Yellow", 2199));
    	curtains.addProduct(new Product("Urban Ladder Door Curtain", "Urban Ladder", "N/A", "N/A", "Beige", 1999));

    	SubCategory wallArt = new SubCategory("Wall Art", 10);
    	wallArt.addProduct(new Product("Canvas Nature Painting", "ArtStreet", "N/A", "N/A", "Green", 1999));
    	wallArt.addProduct(new Product("Abstract Wall Frame", "DecoCraft", "N/A", "N/A", "Multi", 2499));
    	wallArt.addProduct(new Product("Lord Krishna Portrait", "DivineArts", "N/A", "N/A", "Blue", 2999));
    	wallArt.addProduct(new Product("Buddha Wall Painting", "ZenDecor", "N/A", "N/A", "Golden", 2799));
    	wallArt.addProduct(new Product("Modern City Canvas", "UrbanArt", "N/A", "N/A", "Grey", 2299));
    	wallArt.addProduct(new Product("Floral Wall Frame", "FlowerArt", "N/A", "N/A", "Pink", 1899));
    	wallArt.addProduct(new Product("Vintage Map Frame", "ClassicDecor", "N/A", "N/A", "Brown", 2599));
    	wallArt.addProduct(new Product("Motivational Quote Frame", "InspireHome", "N/A", "N/A", "Black", 1499));
    	wallArt.addProduct(new Product("Peacock Feather Art", "EthnicArts", "N/A", "N/A", "Green", 3199));
    	wallArt.addProduct(new Product("3D Wall Sticker Set", "WallMantra", "N/A", "N/A", "Multi", 999));

    	SubCategory furniture = new SubCategory("Furniture", 10);
    	furniture.addProduct(new Product("Godrej Wooden Chair", "Godrej", "N/A", "N/A", "Brown", 4999));
    	furniture.addProduct(new Product("Nilkamal Plastic Table", "Nilkamal", "N/A", "N/A", "White", 2999));
    	furniture.addProduct(new Product("Urban Ladder Sofa Set", "Urban Ladder", "N/A", "N/A", "Grey", 25999));
    	furniture.addProduct(new Product("IKEA Coffee Table", "IKEA", "N/A", "N/A", "Black", 6999));
    	furniture.addProduct(new Product("Wakefit Queen Bed", "Wakefit", "N/A", "N/A", "Walnut", 18999));
    	furniture.addProduct(new Product("Durian Dining Table", "Durian", "N/A", "N/A", "Brown", 22999));
    	furniture.addProduct(new Product("Pepperfry Bookshelf", "Pepperfry", "N/A", "N/A", "Teak", 7999));
    	furniture.addProduct(new Product("HomeTown TV Unit", "HomeTown", "N/A", "N/A", "White", 10999));
    	furniture.addProduct(new Product("Spacewood Wardrobe", "Spacewood", "N/A", "N/A", "Oak", 19999));
    	furniture.addProduct(new Product("Featherlite Office Chair", "Featherlite", "N/A", "N/A", "Black", 8999));

    	homeDecor.addSubCategory(lights);
    	homeDecor.addSubCategory(curtains);
    	homeDecor.addSubCategory(wallArt);
    	homeDecor.addSubCategory(furniture);
    	categories[2] = homeDecor;


        // 4. HOUSEHOLD
    	// HOUSEHOLD
    	Category household = new Category("Household", 4);

    	SubCategory groceries = new SubCategory("Groceries", 10);
    	groceries.addProduct(new Product("Aashirvaad Atta 10kg", "Aashirvaad", "N/A", "10kg", "N/A", 549));
    	groceries.addProduct(new Product("Fortune Sunflower Oil 5L", "Fortune", "N/A", "5L", "N/A", 899));
    	groceries.addProduct(new Product("Daawat Basmati Rice 5kg", "Daawat", "N/A", "5kg", "N/A", 699));
    	groceries.addProduct(new Product("Tata Salt 1kg", "Tata", "N/A", "1kg", "N/A", 28));
    	groceries.addProduct(new Product("Maggi Noodles Pack", "Nestle", "N/A", "12 Packs", "N/A", 144));
    	groceries.addProduct(new Product("Bru Coffee 200g", "Bru", "N/A", "200g", "N/A", 259));
    	groceries.addProduct(new Product("Kissan Jam 500g", "Kissan", "N/A", "500g", "N/A", 210));
    	groceries.addProduct(new Product("Amul Butter 500g", "Amul", "N/A", "500g", "N/A", 265));
    	groceries.addProduct(new Product("Parle-G Biscuits", "Parle", "N/A", "1kg", "N/A", 110));
    	groceries.addProduct(new Product("Surf Excel Detergent 2kg", "Surf Excel", "N/A", "2kg", "N/A", 399));

    	SubCategory utensils = new SubCategory("Utensils", 10);
    	utensils.addProduct(new Product("Prestige Pressure Cooker", "Prestige", "N/A", "5L", "Silver", 2999));
    	utensils.addProduct(new Product("Hawkins Nonstick Pan", "Hawkins", "N/A", "28cm", "Black", 1799));
    	utensils.addProduct(new Product("Pigeon Gas Stove", "Pigeon", "N/A", "2 Burner", "Black", 2499));
    	utensils.addProduct(new Product("Milton Casserole Set", "Milton", "N/A", "3 Pieces", "Red", 1899));
    	utensils.addProduct(new Product("Butterfly Mixer Grinder", "Butterfly", "N/A", "750W", "White", 3499));
    	utensils.addProduct(new Product("Cello Dinner Set", "Cello", "N/A", "24 Pieces", "White", 2999));
    	utensils.addProduct(new Product("Bajaj Electric Kettle", "Bajaj", "N/A", "1.5L", "Silver", 1599));
    	utensils.addProduct(new Product("Prestige Induction Cooktop", "Prestige", "N/A", "1200W", "Black", 2799));
    	utensils.addProduct(new Product("Philips Rice Cooker", "Philips", "N/A", "1.8L", "White", 3199));
    	utensils.addProduct(new Product("Wonderchef Toaster", "Wonderchef", "N/A", "800W", "Red", 1999));

    	SubCategory cleaning = new SubCategory("Cleaning", 10);
    	cleaning.addProduct(new Product("Harpic Toilet Cleaner", "Harpic", "N/A", "1L", "Blue", 199));
    	cleaning.addProduct(new Product("Lizol Floor Cleaner", "Lizol", "N/A", "2L", "Green", 299));
    	cleaning.addProduct(new Product("Dettol Disinfectant Liquid", "Dettol", "N/A", "1L", "Brown", 249));
    	cleaning.addProduct(new Product("Vim Dishwash Gel", "Vim", "N/A", "750ml", "Yellow", 145));
    	cleaning.addProduct(new Product("Colin Glass Cleaner", "Colin", "N/A", "500ml", "Blue", 120));
    	cleaning.addProduct(new Product("Surf Excel Liquid", "Surf Excel", "N/A", "2L", "Blue", 399));
    	cleaning.addProduct(new Product("Odonil Air Freshener", "Odonil", "N/A", "200g", "Pink", 180));
    	cleaning.addProduct(new Product("Good Knight Mosquito Refill", "Good Knight", "N/A", "45ml", "Green", 99));
    	cleaning.addProduct(new Product("Domex Toilet Cleaner", "Domex", "N/A", "1L", "Blue", 210));
    	cleaning.addProduct(new Product("Pril Dishwash Bar", "Pril", "N/A", "3 Pack", "Green", 90));

    	SubCategory storage = new SubCategory("Storage", 10);
    	storage.addProduct(new Product("Cello Plastic Storage Box", "Cello", "N/A", "20L", "Blue", 699));
    	storage.addProduct(new Product("Nilkamal Storage Cabinet", "Nilkamal", "N/A", "Large", "Brown", 3499));
    	storage.addProduct(new Product("IKEA Clothes Organizer", "IKEA", "N/A", "Medium", "Grey", 1299));
    	storage.addProduct(new Product("AmazonBasics Shoe Rack", "AmazonBasics", "N/A", "10 Pairs", "Black", 2499));
    	storage.addProduct(new Product("Milton Lunch Box Set", "Milton", "N/A", "4 Boxes", "Red", 899));
    	storage.addProduct(new Product("Tupperware Container Set", "Tupperware", "N/A", "10 Pieces", "Purple", 1999));
    	storage.addProduct(new Product("Spacewood Drawer Unit", "Spacewood", "N/A", "4 Drawer", "White", 5999));
    	storage.addProduct(new Product("Godrej Almirah", "Godrej", "N/A", "Large", "Grey", 12999));
    	storage.addProduct(new Product("HOMESAKE Basket Set", "HOMESAKE", "N/A", "3 Pieces", "Beige", 1599));
    	storage.addProduct(new Product("Urban Ladder Storage Trunk", "Urban Ladder", "N/A", "Large", "Brown", 8999));

    	household.addSubCategory(groceries);
    	household.addSubCategory(utensils);
    	household.addSubCategory(cleaning);
    	household.addSubCategory(storage);
    	categories[3] = household;


        // 5. STATIONERY
    	// STATIONERY
    	Category stationery = new Category("Stationery", 4);

    	SubCategory pens = new SubCategory("Pens", 10);
    	pens.addProduct(new Product("Reynolds Trimax Pen", "Reynolds", "N/A", "N/A", "Blue", 50));
    	pens.addProduct(new Product("Cello Gripper Pen", "Cello", "N/A", "N/A", "Black", 20));
    	pens.addProduct(new Product("Parker Vector Pen", "Parker", "N/A", "N/A", "Silver", 350));
    	pens.addProduct(new Product("Pilot Hi-Tecpoint Pen", "Pilot", "N/A", "N/A", "Blue", 40));
    	pens.addProduct(new Product("Flair Writo Meter Pen", "Flair", "N/A", "N/A", "Green", 25));
    	pens.addProduct(new Product("Luxor Gel Pen", "Luxor", "N/A", "N/A", "Red", 30));
    	pens.addProduct(new Product("Uniball Eye Pen", "Uniball", "N/A", "N/A", "Black", 60));
    	pens.addProduct(new Product("Hauser XO Pen", "Hauser", "N/A", "N/A", "Blue", 35));
    	pens.addProduct(new Product("Add Gel Achiever Pen", "AddGel", "N/A", "N/A", "Purple", 45));
    	pens.addProduct(new Product("Camlin Fountain Pen", "Camlin", "N/A", "N/A", "Black", 120));

    	SubCategory books = new SubCategory("Books", 10);
    	books.addProduct(new Product("Classmate Long Notebook", "Classmate", "N/A", "200 Pages", "Blue", 90));
    	books.addProduct(new Product("Navneet Youva Notebook", "Navneet", "N/A", "180 Pages", "Red", 85));
    	books.addProduct(new Product("Oxford Spiral Notebook", "Oxford", "N/A", "300 Pages", "Green", 180));
    	books.addProduct(new Product("Apsara Drawing Book", "Apsara", "N/A", "100 Pages", "White", 120));
    	books.addProduct(new Product("Camlin Exam Pad", "Camlin", "N/A", "200 Pages", "Yellow", 150));
    	books.addProduct(new Product("Paperkraft Project Book", "Paperkraft", "N/A", "250 Pages", "Brown", 220));
    	books.addProduct(new Product("JK Copier Paper", "JK", "N/A", "500 Sheets", "White", 280));
    	books.addProduct(new Product("ITC Classmate Register", "Classmate", "N/A", "400 Pages", "Purple", 200));
    	books.addProduct(new Product("S Chand Practical Record", "S Chand", "N/A", "200 Pages", "Green", 160));
    	books.addProduct(new Product("Arihant Exam Guide", "Arihant", "N/A", "500 Pages", "Multi", 350));

    	SubCategory bags = new SubCategory("Bags", 10);
    	bags.addProduct(new Product("Skybags College Backpack", "Skybags", "N/A", "30L", "Black", 1999));
    	bags.addProduct(new Product("American Tourister Laptop Bag", "American Tourister", "N/A", "25L", "Grey", 2499));
    	bags.addProduct(new Product("Wildcraft Trekking Bag", "Wildcraft", "N/A", "40L", "Blue", 2999));
    	bags.addProduct(new Product("Nike Sports Duffle Bag", "Nike", "N/A", "35L", "Red", 2799));
    	bags.addProduct(new Product("Adidas School Bag", "Adidas", "N/A", "28L", "Green", 2299));
    	bags.addProduct(new Product("Puma Gym Bag", "Puma", "N/A", "32L", "Black", 1899));
    	bags.addProduct(new Product("VIP Travel Backpack", "VIP", "N/A", "45L", "Brown", 3199));
    	bags.addProduct(new Product("Safari Trolley Bag", "Safari", "N/A", "60L", "Blue", 5999));
    	bags.addProduct(new Product("F Gear Office Bag", "F Gear", "N/A", "20L", "Grey", 1599));
    	bags.addProduct(new Product("Lavie Women Handbag", "Lavie", "N/A", "15L", "Pink", 1799));

    	SubCategory geometry = new SubCategory("Geometry", 10);
    	geometry.addProduct(new Product("Camlin Geometry Box", "Camlin", "N/A", "Box Set", "Blue", 120));
    	geometry.addProduct(new Product("Apsara Mathematical Instruments", "Apsara", "N/A", "Box Set", "Red", 100));
    	geometry.addProduct(new Product("Classmate Compass Box", "Classmate", "N/A", "Box Set", "Green", 130));
    	geometry.addProduct(new Product("Faber-Castell Geometry Kit", "FaberCastell", "N/A", "Box Set", "Black", 180));
    	geometry.addProduct(new Product("Maped Geometry Set", "Maped", "N/A", "Box Set", "Yellow", 160));
    	geometry.addProduct(new Product("Staedtler Compass Set", "Staedtler", "N/A", "Box Set", "Grey", 220));
    	geometry.addProduct(new Product("Kokuyo Geometry Tools", "Kokuyo", "N/A", "Box Set", "White", 200));
    	geometry.addProduct(new Product("Luxor Student Geometry Box", "Luxor", "N/A", "Box Set", "Orange", 140));
    	geometry.addProduct(new Product("DOMS Geometry Box", "DOMS", "N/A", "Box Set", "Purple", 110));
    	geometry.addProduct(new Product("Nataraj Mathematical Set", "Nataraj", "N/A", "Box Set", "Blue", 90));

    	stationery.addSubCategory(pens);
    	stationery.addSubCategory(books);
    	stationery.addSubCategory(bags);
    	stationery.addSubCategory(geometry);
    	categories[4] = stationery;

    }}

