package ru.mirea.leonidova;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CountrySelector {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор страны");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Выберите страну:");
        JComboBox<String> comboBox = new JComboBox<>(new String[] { "Australia", "China", "England", "Russia" });
        JLabel result = new JLabel("Информация о стране");

        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            result.setText("Вы выбрали: " + selected);
        });

        frame.add(label);
        frame.add(comboBox);
        frame.add(result);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

