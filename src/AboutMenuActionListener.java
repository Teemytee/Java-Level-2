import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMenuActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JFrame f = new JFrame("О программе");
        JOptionPane.showMessageDialog(f, "Это чат, созданный с помощью Java Swing для GB");
    }
}
