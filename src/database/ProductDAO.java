package database;

import inventory.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO {
    public void addProduct() {
        try (Connection conn = DBConnection.getConnection()) { // Get the connection here
            String query = "INSERT INTO products (product_name, price, category, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "Hamam");
            ps.setDouble(2, 20);
            ps.setString(3, "bath");
            ps.setInt(4, 10);
            ps.executeUpdate();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
