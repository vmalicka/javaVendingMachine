public class Main {
    public static void main(String[]args){
        VendingMachine vendingMachine = new VendingMachine(); vendingMachine.start();
        vendingMachine.welcomeUser();
        vendingMachine.displayCategories();
        vendingMachine.startShopping();
        vendingMachine.processPayment();
        vendingMachine.thankUser();
    }
}
