package user_interface;
import database.ProductDAO;
import inventory.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    public void startApplication() {
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
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);
        gbc.anchor = GridBagConstraints.WEST; // Align labels to the left

        Font largeFont = new Font("Arial", Font.BOLD, 30);

        // Helper function to create and configure labels and text fields
        class FormField {
            JLabel label;
            JTextField textField;

            FormField(String labelText) {
                label = new JLabel(labelText);
                label.setFont(largeFont);
                textField = new JTextField(15);
                textField.setPreferredSize(new Dimension(200, 40)); // Consistent width
                textField.setFont(largeFont);
            }
            // *** Add the getText() method ***
            public String getText() {
                return textField.getText();
            }

            // A method to clear the text field (good practice)
            public void clear() {
                textField.setText("");
            }
        }

        // Create form fields using the helper class
        FormField nameField = new FormField("Product Name:");
        FormField quantityField = new FormField("Quantity:");
        FormField priceField = new FormField("Price:");
        FormField categoryField = new FormField("Category:");

        // Add form fields to the panel using a loop
        FormField[] fields = {nameField, quantityField, priceField, categoryField};
        int gridy = 0;
        for (FormField field : fields) {
            gbc.gridx = 0;
            gbc.gridy = gridy;
            panel.add(field.label, gbc);

            gbc.gridx = 1;
            panel.add(field.textField, gbc);
            gridy++;
        }

        // Add Button
        JButton addButton = new JButton("Add Product");
        addButton.setFont(largeFont);
        gbc.gridx = 0;
        gbc.gridy = gridy; // Use the incremented gridy
        gbc.gridwidth = 2; // Span two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        panel.add(addButton, gbc);

        //Action listener for database connection
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText()); // Handle parsing errors!
                int quantity = Integer.parseInt(quantityField.getText());
                String category = categoryField.getText();

                Product newProduct = new Product(name, price, category, quantity);
                ProductDAO productDAO = new ProductDAO();
                productDAO.addProduct(newProduct);

            }
        });

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
