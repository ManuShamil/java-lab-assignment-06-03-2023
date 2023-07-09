package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookstoreGUI extends JFrame {
    private JTextArea bookDisplayArea;
    private JButton addToCartButton;
    private JButton removeFromCartButton;
    private JButton checkoutButton;
    private JTextField bookInputField;
    private JTextArea cartDisplayArea;

    public BookstoreGUI() {
        setTitle("Online Bookstore");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Book Display Area
        bookDisplayArea = new JTextArea();
        bookDisplayArea.setEditable(false);
        JScrollPane bookScrollPane = new JScrollPane(bookDisplayArea);
        add(bookScrollPane, BorderLayout.CENTER);

        // User Input Field
        bookInputField = new JTextField();
        add(bookInputField, BorderLayout.NORTH);

        // Cart Display Area
        cartDisplayArea = new JTextArea();
        cartDisplayArea.setEditable(false);
        JScrollPane cartScrollPane = new JScrollPane(cartDisplayArea);
        add(cartScrollPane, BorderLayout.EAST);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        addToCartButton = new JButton("Add to Cart");
        removeFromCartButton = new JButton("Remove from Cart");
        checkoutButton = new JButton("Checkout");
        buttonPanel.add(addToCartButton);
        buttonPanel.add(removeFromCartButton);
        buttonPanel.add(checkoutButton);
        add(buttonPanel, BorderLayout.WEST);

        // Event Listeners
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookInputField.getText();
                // Add book to the cart
                cartDisplayArea.append(book + "\n");
                bookInputField.setText("");
            }
        });

        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = cartDisplayArea.getSelectedText();
                // Remove selected book from the cart
                if (selectedBook != null) {
                    cartDisplayArea.replaceSelection("");
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartDisplayArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(BookstoreGUI.this,
                            "Your cart is empty. Please add books before checking out.",
                            "Empty Cart", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Perform checkout process
                    JOptionPane.showMessageDialog(BookstoreGUI.this,
                            "Thank you for your purchase! Your order has been processed.",
                            "Checkout", JOptionPane.INFORMATION_MESSAGE);
                    cartDisplayArea.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BookstoreGUI bookstoreGUI = new BookstoreGUI();
                bookstoreGUI.setVisible(true);
            }
        });
    }
}
