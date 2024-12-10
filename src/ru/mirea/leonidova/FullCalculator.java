package ru.mirea.leonidova;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FullCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор");
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+" };

        // Вспомогательные переменные
        final String[] operator = { "" }; // Оператор
        final double[] num1 = { 0 };      // Первое число

        for (String text : buttons) {
            JButton button = new JButton(text);
            buttonPanel.add(button);

            button.addActionListener(e -> {
                String input = button.getText();

                if ("0123456789".contains(input)) {
                    // Если нажата цифра, добавляем ее к текущему тексту
                    display.setText(display.getText() + input);
                } else if ("+-*/".contains(input)) {
                    // Если выбран оператор, сохраняем текущее число и оператор
                    num1[0] = Double.parseDouble(display.getText());
                    operator[0] = input;
                    display.setText(""); // Очищаем поле ввода для второго числа
                } else if (input.equals("=")) {
                    // Если нажато "=", выполняем операцию
                    double num2 = Double.parseDouble(display.getText());
                    double result = 0;

                    switch (operator[0]) {
                        case "+":
                            result = num1[0] + num2;
                            break;
                        case "-":
                            result = num1[0] - num2;
                            break;
                        case "*":
                            result = num1[0] * num2;
                            break;
                        case "/":
                            result = num2 != 0 ? num1[0] / num2 : Double.NaN; // Проверяем деление на 0
                            break;
                    }

                    display.setText(String.valueOf(result)); // Отображаем результат
                } else if (input.equals("C")) {
                    // Если нажато "C", очищаем все
                    display.setText("");
                    num1[0] = 0;
                    operator[0] = "";
                }
            });
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
