import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener implements ActionListener {
    private JTextArea jTextAreaMessage;
    private JTextField jtfMessage;

    public SendButtonListener(JTextArea jTextAreaMessage, JTextField jtfMessage) {
        this.jTextAreaMessage = jTextAreaMessage;
        this.jtfMessage = jtfMessage;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(!jtfMessage.getText().trim().isEmpty()){
            jTextAreaMessage.append(jtfMessage.getText());
            jTextAreaMessage.append("\n");
            jtfMessage.setText("");
        }
    }

}
