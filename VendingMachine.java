public class VendingMachine {
    VendingMachine {
        Inventory inventory;
        double totalPurchase;

        public VendingMachine() {
            inventory = new Inventory();
            totalPurchase = 0.0;
        }
        //vendingmachine is the object, addProduct() is the method
        vendingMachine.addProduct(0, 0, "Soda");  //row 0, col 0
        vendingMachine.addProduct(0, 1, "Chips");
        vendingMachine.addProduct(0, 2, "Gum");
        vendingMachine.addProduct(1, 0, "poprocks");
        vendingMachine.addProduct(1, 1, "Candy");
        vendingMachine.addProduct(1, 2, "Gum");
        vendingMachine.addProduct(2, 2, "Water");

        //Show all the contents in the Vending Machine
        System.out.println("Vending Machine Contents:");
        vendingMachine.display();

        //Get some of the products from the Vending Machine product inventory
        System.out.println("\nGetting products from the vending machine:");
        System.out.println("1. " + vendingMachine.getProduct(0, 0));  //Get the soda
        System.out.println("2. " + vendingMachine.getProduct(0, 1));  //get the chips
        System.out.println("3. " + vendingMachine.getProduct(1, 1));  //get the candy
        System.out.println("4. " + vendingMachine.getProduct(2, 2));  //get the water

        //Display what is left in inventory
        System.out.println("\nUpdated Vending Machine Contents:");
        vendingMachine.display();  //Only Gum and poprocks are the products left
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

}

