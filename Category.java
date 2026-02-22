package e_commerce;

public class Category {

    String name;
    SubCategory[] subCategories;   
    int count = 0;


    public Category(String name, int size) {
        this.name = name;
        subCategories = new SubCategory[size];
    }

    public void addSubCategory(SubCategory sc) {
        if (count < subCategories.length) {
            subCategories[count] = sc;
            count++;
        }
    }

    public void displaySubCategories() {
        System.out.println("\nCategory: " + name);
        System.out.println("---------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + subCategories[i].name);
        }
    }

    public SubCategory getSubCategory(int index) {
        if (index >= 0 && index < count) {
            return subCategories[index];
        }
        return null;
    }
}

