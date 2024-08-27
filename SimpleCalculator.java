import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String currentInput = "";
    private double result = 0;
    private String operator = "";
    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        String[] buttons = {
            "1", "2", "3", "C", "4","5", "6", "+", "7",
            "8", "9", "-", "*","0", "/", "="
        };
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            currentInput += command;
            display.setText(currentInput);
        } else if (command.equals("C")) {
            currentInput = "";
            result = 0;
            operator = "";
            display.setText("");
        } else if (command.equals("=")) {
            try {
                double num = Double.parseDouble(currentInput);
                switch (operator) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        result /= num;
                        break;
                    default:
                        result = num;
                        break;
                }
                display.setText(String.valueOf(result));
                currentInput = "";
                operator = "";
            } catch (Exception ex) {
                display.setText("Error");
                currentInput = "";
                operator = "";
            }
        } else {
            if (!currentInput.isEmpty()) {
                double num = Double.parseDouble(currentInput);
                switch (operator) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        result /= num;
                        break;
                    default:
                        result = num;
                        break;
                }
                display.setText(String.valueOf(result));
                currentInput = "";
                operator = command;
            } else {
                operator = command;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}
