
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
        Ветвление в классах операция стоит для следующего случая:
        Например пользователь захотел сложить два числа, допустим
        8 и 1. Пользователь вводит цифру 8, нажимает на кнопку сложения, но
        его цель меняется, теперь он хочет вычесть 1 из 8. Без ветвления,
        нажатие кнопки определенной операции не позволяло нажать на кнопку
        другой операции, вылезала куча ошибок. А теперь можно ввести цифру,
        нажать на кнопку операции, сменить тип операции на другую и ввести
        второе число.
         */




public class MyWindow extends JFrame {
    public static String operation;
    public static double firstDigit;
    public static double secondDigit;
    public MyWindow() {
        setTitle("Calculator");
        setBounds(100, 100, 300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        add(top, BorderLayout.CENTER);
        top.setLayout(new GridLayout(4, 3));
        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);
        AdditionButtonListener additionButtonListener = new AdditionButtonListener(inputField);
        EqualsButtonListener equalsButtonListener = new EqualsButtonListener(inputField);
        SubtractionButtonListener subtractionButtonListener = new SubtractionButtonListener(inputField);
        MultiplicationButtonListener multiplicationButtonListener = new MultiplicationButtonListener(inputField);
        DivisionButtonListener divisionButtonListener = new DivisionButtonListener(inputField);
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonListener);
            top.add(btn);
        }

        JButton add = new JButton("+");
        add.addActionListener(additionButtonListener);
        top.add(add);
        JButton minus = new JButton("-");
        minus.addActionListener(subtractionButtonListener);
        top.add(minus);
        JButton multiple = new JButton("*");
        multiple.addActionListener(multiplicationButtonListener);
        top.add(multiple);
        JButton divide = new JButton("/");
        divide.addActionListener(divisionButtonListener);
        top.add(divide);
        JButton pow = new JButton("^");
        top.add(pow);
        JButton calc = new JButton("=");
        calc.addActionListener(equalsButtonListener);
        top.add(calc);


        bottom.add(inputField, BorderLayout.CENTER);
        JButton clear = new JButton("C");
        clear.addActionListener(new ClearButtonListener(inputField));
        bottom.add(clear, BorderLayout.EAST);

        setVisible(true);

        new ClearButtonListener(inputField);
    }

    public static class ClearButtonListener implements ActionListener {
        private JTextField inputField;

        public ClearButtonListener(JTextField inputField) {
            this.inputField = inputField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
        }
    }
}
