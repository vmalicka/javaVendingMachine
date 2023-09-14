public class Inventory {
        private Product[][][] products;

        public Inventory() {
            products = new Product[6][6][6];
        }

        public void addProduct(Product product, int row, int column, int stack) {
            products[row][column][stack] = product;
        }

        public Product getProduct(int row, int column, int stack) {
            return products[row][column][stack];
        }
    }

