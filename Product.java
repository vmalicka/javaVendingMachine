// Class representing a product
public class Product {
    private String name;
    private double price;
    private Category category;
    private String nutritionalFacts;

    public Product(String name, double price, Category category, String nutritionalFacts) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.nutritionalFacts = nutritionalFacts;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Category getCategory() {
        return category;
    }
    public String getNutritionalFacts() {
        return nutritionalFacts;
    }
}
