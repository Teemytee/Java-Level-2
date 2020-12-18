import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualsButtonListener implements ActionListener {
    private JTextField inputField;
    public double result;

    public EqualsButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        В случае, если пользователь по ошибке нажмет
        операцию вычисления, до того как введет второе число
        этот if его подхватит и не даст калькулятору рухнуть
         */
        if (inputField.getText().equals("")){
            MyWindow.secondDigit = 0;
        } else{
            MyWindow.secondDigit = Integer.parseInt(inputField.getText());
        }


        if (MyWindow.operation.equals("+")) {
            result = MyWindow.secondDigit + MyWindow.firstDigit;
        }
        if (MyWindow.operation.equals("-")) {
            result = MyWindow.firstDigit - MyWindow.secondDigit;
        }
        if (MyWindow.operation.equals("*")) {
            result = MyWindow.firstDigit * MyWindow.secondDigit;
        }
        if (MyWindow.operation.equals("/")) {
            result = MyWindow.firstDigit / MyWindow.secondDigit;
        }
        inputField.setText(Double.toString(result));
    }
}