public class Product {
        private String name;
        private double price;
        private String nutritionFacts;
        private ProductCategory category;

        public Product(String name, double price, String nutritionFacts, ProductCategory category) {
            this.name = name;
            this.price = price;
            this.nutritionFacts = nutritionFacts;
            this.category = category;
        }
        public String getName(){
            return name;
        }
        public double getPrice(){
            return price;
        }
        public String getNutritionFacts(){
            return nutritionFacts;
        }
        public ProductCategory getCategory(){
            return category;
        }

    }
