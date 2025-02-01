package user_interface;
import javax.swing.*;
import java.awt.*;

public class UserInterface {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Gandhi Store");

        //when the user clicks the close button, the application should terminate and exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame to full screen by maximizing it
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //frame.setSize(400,500);
        //----------------------------------------------------------------------------------

        // Create the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Increase tab height and width
        //tabbedPane.setPreferredSize(new Dimension(300, 50));

        // Option 1: Increase the font size of the tabs
        Font bigFont = new Font("Roboto", Font.BOLD, 30);
        tabbedPane.setFont(bigFont);

        // Create panels for each tab and add them to the tabbed pane
        JPanel productsPanel = createProductsPanel();
        JPanel suppliersPanel = createSuppliersPanel();
        JPanel customersPanel = createCustomersPanel();

        // Add tabs to the tabbedPane
        tabbedPane.addTab("Products", productsPanel);
        tabbedPane.addTab("Suppliers", suppliersPanel);
        tabbedPane.addTab("Customers", customersPanel);

        // Add the tabbed pane to the main frame
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    private static JPanel createProductsPanel() {
        JPanel panel = new JPanel();
//        panel.add(new JLabel("Product Management"));
        // Add more components like buttons, tables, etc., as needed

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);

        Font largeFont = new Font("Arial", Font.BOLD, 30);

        // Form fields for product details
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setFont(largeFont);
        JTextField nameField = new JTextField(15);
        nameField.setPreferredSize(new Dimension(40, 40));
        nameField.setFont(largeFont);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(largeFont);
        JTextField quantityField = new JTextField(15);
        quantityField.setPreferredSize(new Dimension(40,40));
        quantityField.setFont(largeFont);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(largeFont);
        JTextField priceField = new JTextField(15);
        priceField.setPreferredSize(new Dimension(40,40));
        priceField.setFont(largeFont);
        // Add fields to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(quantityLabel, gbc);

        gbc.gridx = 1;
        panel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(priceLabel, gbc);

        gbc.gridx = 1;
        panel.add(priceField, gbc);

        // Add Button
        JButton addButton = new JButton("Add Product");
        addButton.setFont(largeFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(addButton, gbc);

        return panel;
    }

    private static JPanel createSuppliersPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Supplier Management"));
        // Add more components as needed
        return panel;
    }

    private static JPanel createCustomersPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Customer Management"));
        // Add more components as needed
        return panel;
    }
}
