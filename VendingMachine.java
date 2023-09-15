import java.util.Scanner;

public class VendingMachine {
    public class Main {
        public static void main(String[] args) {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.welcomeUser();
            vendingMachine.displayCategories();
            vendingMachine.startShopping();
            vendingMachine.processPayment();
            vendingMachine.thankUser();

        }
    }

    private Inventory inventory;
    private double totalPurchase;

    public VendingMachine() {
        inventory = new Inventory();
        totalPurchase = 0.0;
    }

    public void Inventory() {
        // Adding products to the inventory
        inventory.addProduct(new Product("Lays", 1.5, Category.SNACKS, "Calories: 150, Fat: 10g, Carbs: 15g"), 0, 0, 0);
        inventory.addProduct(new Product("Doritos", 1.8, Category.SNACKS, "Calories: 140, Fat: 8g, Carbs: 16g"), 0, 1, 0);
        inventory.addProduct(new Product("Coca Cola", 2.0, Category.BEVERAGES, "Calories: 140, Sugar: 39g, Sodium: 45mg"), 1, 0, 0);
        inventory.addProduct(new Product("Pepsi", 1.9, Category.BEVERAGES, "Calories: 150, Sugar: 41g, Sodium: 30mg"), 1, 1, 0);
        // Add more products as needed
    }

    public void welcomeUser() {
        System.out.println("Welcome to the Vending Machine!");
    }

    public void displayCategories() {
        System.out.println("Categories:");
        for (Category category : Category.values()) {
            System.out.println(category.ordinal() + ". " + category.name());
        }
    }

    public void displayProductsByCategory(Category category) {
        System.out.println("Products in " + category.name() + ":");
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 6; column++) {
                for (int stack = 0; stack < 6; stack++) {
                    Product product = inventory.getProduct(row, column, stack);
                    if (product != null && product.getCategory() == category) {
                        System.out.println(product.getName() + " - $" + product.getPrice());
                    }
                }
            }
        }
    }

        public void selectProduct(Category category, int row, int column, int stack) {
            Product product = inventory.getProduct(row, column, stack);
            if (product != null && product.getCategory() == category) {
                System.out.println("Selected Product: " + product.getName());
                System.out.println("Nutritional Facts: " + product.getNutritionalFacts());
                totalPurchase += product.getPrice();
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        public void processPayment() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the amount in cash: $");
            double cash = scanner.nextDouble();
            if (cash >= totalPurchase) {
                double change = cash - totalPurchase;
                System.out.println("Payment successful. Change: $" + change);
            } else {
                System.out.println("Insufficient payment. Please try again.");
            }
            scanner.close();
        }

        public void startShopping() {
            Scanner scanner = new Scanner(System.in);
            boolean continueShopping = true;
            while (continueShopping) {
                System.out.print("Enter the category number to view products (or -1 to stop shopping): ");
                int categoryNumber = scanner.nextInt();
                if (categoryNumber == -1) {
                    continueShopping = false;
                } else if (categoryNumber >= 0 && categoryNumber < Category.values().length) {
                    Category selectedCategory = Category.values()[categoryNumber];
                    displayProductsByCategory(selectedCategory);
                    System.out.print("Enter the row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter the column number: ");
                    int column = scanner.nextInt();
                    System.out.print("Enter the stack number: ");
                    int stack = scanner.nextInt();
                    selectProduct(selectedCategory, row, column, stack);
                } else {
                    System.out.println("Invalid category number. Please try again.");
                }
            }
            scanner.close();
        }
        public void thankUser() {
            System.out.println("Thank you for your purchase!");
            System.out.println("Total Purchase: $" + totalPurchase);
        }
}


