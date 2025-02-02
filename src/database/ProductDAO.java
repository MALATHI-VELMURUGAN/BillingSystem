package database;

import inventory.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO {
    public void addProduct(Product product) {
        try (Connection conn = DBConnection.getConnection()) { // Get the connection here
            String query = "INSERT INTO products (product_name, price, category, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, product.getProduct_name());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.setInt(4, product.getStock());
            ps.executeUpdate();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
