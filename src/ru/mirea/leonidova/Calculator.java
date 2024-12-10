package ru.mirea.leonidova;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel label1 = new JLabel("Число 1:");
        JTextField text1 = new JTextField();
        JLabel label2 = new JLabel("Число 2:");
        JTextField text2 = new JTextField();
        JLabel resultLabel = new JLabel("Результат:");
        JTextField result = new JTextField();
        result.setEditable(false);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4));
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");

        buttonsPanel.add(addButton);
        buttonsPanel.add(subButton);
        buttonsPanel.add(mulButton);
        buttonsPanel.add(divButton);

        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(resultLabel);
        frame.add(result);
        frame.add(buttonsPanel);

        addButton.addActionListener(e -> {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            result.setText(String.valueOf(num1 + num2));
        });

        subButton.addActionListener(e -> {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            result.setText(String.valueOf(num1 - num2));
        });

        mulButton.addActionListener(e -> {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            result.setText(String.valueOf(num1 * num2));
        });

        divButton.addActionListener(e -> {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            if (num2 != 0) {
                result.setText(String.valueOf(num1 / num2));
            } else {
                result.setText("Деление на 0!");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

