import java.util.Scanner;

public class VendingMachine {
    public static class Main {

        public static void main(String[] args) {

            VendingMachine VendingMachine = new VendingMachine();

            VendingMachine.welcomeUser();

            VendingMachine.displayCategories();

            VendingMachine.startShopping();

            VendingMachine.processPayment();

            VendingMachine.thankUser();

        }
    }

    private final Inventory inventory;
    private double totalPurchase;

    public VendingMachine() {
        inventory = new Inventory();
        totalPurchase = 0.0;


        // Adding products to the inventory

        inventory.addProduct(new Product("Chips", 1.23, Category.SNACKS, "Calories: 200, Fat: 15g, Carbs: 30g"), 0, 0, 0);

        inventory.addProduct(new Product("Water", 1.56, Category.BEVERAGES, "Calories: 150, Fat: 22g, Carbs: 4g"), 0, 1, 0);

        inventory.addProduct(new Product("Soda", 3.70, Category.BEVERAGES, "Calories: 170, Sugar: 35g, Sodium: 15mg"), 1, 0, 0);

        inventory.addProduct(new Product("Juice", 1.90, Category.BEVERAGES, "Calories: 130, Sugar: 37g, Sodium: 20mg"), 1, 1, 0);

    }
    public void Inventory() {

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
    public void displayByCategory(Category category) {

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

        if (product != null) {

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

            System.out.println("Receipt:");

            System.out.println("Total Purchase: $" + totalPurchase);

            System.out.println("Payment: $" + cash);

            System.out.println("Change: $" + change);

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


                //displayCategories();

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

        processPayment();

        scanner.close();

    }

    public void thankUser() {

        System.out.println("Thank you for your purchase!");

        System.out.println("Total Purchase: $" + totalPurchase);

    }

}

