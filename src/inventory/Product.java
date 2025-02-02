package inventory;

public class Product {
    private String product_id;//ID is auto generated in the database
    private String product_name;
    private double price;
    private String category;
    private int stock;

    public Product(String product_name, double price, String category, int stock) {
        this.product_name = product_name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
