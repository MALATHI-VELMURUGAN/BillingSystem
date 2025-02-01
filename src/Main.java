import database.ProductDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Supermarket Billing System!");
        ProductDAO productDAO = new ProductDAO();
        productDAO.addProduct();
    }
}
