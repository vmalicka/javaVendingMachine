import java.util.Scanner;
public class VendingMachine {
    private static double showTotalPrice = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        System.out.println("Welcome to the Vending Machine!!");

        while (true) {
            displayInventory(inventory);
            System.out.print("Enter row (0-5) and column (0-5) to select a product");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if (!inventory.checkValid(row, column, 0)) {
                System.out.println("Invalid selection. Please try again.");
                continue;
            }
            int stack = 0;
            Product selectedProduct = inventory.getProduct(row, column, stack);
            System.out.println("Selected: " + selectedProduct.getName());
            System.out.println("Category: " + selectedProduct.getCategory());
            System.out.println("Nutrition Facts: " + selectedProduct.getNutritionFacts());
            System.out.println("Price: $" + selectedProduct.getPrice());

            System.out.print("Enter payment amount: $");
            double payment = scanner.nextDouble();

            if (payment < selectedProduct.getPrice()) {
                System.out.println("Insufficient payment. Please insert more.");
            } else {
                showTotalPrice += selectedProduct.getPrice();
                inventory.decreaseStock(row, column, stack);
                double change = payment - selectedProduct.getPrice();
                System.out.println("Thank you!");
                System.out.println("Change: $" + change);
            }
            System.out.print("Do you wish to continue shopping?(YES/NO): ");
            String continueShopping = scanner.next().toUpperCase();
            if (!continueShopping.equals("YES")) {
                break;
            }
        }
        System.out.println("Total Cost: $" + showTotalPrice);
        System.out.println("Thank you for shopping with us!");
    }

    private static void displayInventory(Inventory inventory) {
        System.out.println("Available Products: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (inventory.checkValid(i, j, 0)) {
                    Product product = inventory.getProduct(i, j, 0);
                    System.out.println("Row: " + i + ", Column: " + j + " " + product.getName() + " - $" + product.getPrice());
                    {
                    }
                }
            }
        }
    }
}

