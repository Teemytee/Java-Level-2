import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubtractionButtonListener implements ActionListener {
    private JTextField inputField;


    public SubtractionButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (inputField.getText().equals("")){
            MyWindow.operation = "-";
        }else {
            MyWindow.operation = "-";
            MyWindow.firstDigit = Double.parseDouble(inputField.getText());
            inputField.setText("");

        }
    }
}