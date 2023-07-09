package TemperatureGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JTextField celsiusTextField;
    private JTextField fahrenheitTextField;
    private JTextField kelvinTextField;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel celsiusLabel = new JLabel("Celsius:");
        celsiusTextField = new JTextField(10);
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        fahrenheitTextField = new JTextField(10);
        JLabel kelvinLabel = new JLabel("Kelvin:");
        kelvinTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");

        // Set layout
        setLayout(new GridLayout(4, 2, 10, 10));

        // Add components to the frame
        add(celsiusLabel);
        add(celsiusTextField);
        add(fahrenheitLabel);
        add(fahrenheitTextField);
        add(kelvinLabel);
        add(kelvinTextField);
        add(convertButton);

        // Register ActionListener for the convertButton
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String celsiusText = celsiusTextField.getText();

        // Check if the input is valid
        if (celsiusText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a temperature in Celsius.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convert the Celsius value to double
            double celsius = Double.parseDouble(celsiusText);

            // Convert Celsius to Fahrenheit
            double fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitTextField.setText(String.format("%.2f", fahrenheit));

            // Convert Celsius to Kelvin
            double kelvin = celsius + 273.15;
            kelvinTextField.setText(String.format("%.2f", kelvin));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid temperature value.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterGUI().setVisible(true);
            }
        });
    }
}
