import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {
    private JTextField jtfMessage;
    private JTextArea jTextAreaMessage;

    public ChatWindow(){
        setBounds(600, 300, 600, 500);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextAreaMessage = new JTextArea();
        jTextAreaMessage.setEditable(false);
        jTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jTextAreaMessage);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jtfMessage = new JTextField();
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        SendButtonListener sendMessageListener = new SendButtonListener(jTextAreaMessage, jtfMessage);
        jbSendMessage.addActionListener(sendMessageListener);
        jtfMessage.addActionListener(sendMessageListener);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        JMenuItem exit = new JMenuItem("Выход");
        JMenu aboutProgram = new JMenu("О программе");
        JMenuItem information = new JMenuItem("Информация");
        ExitMenuButtonListener exitMenuButtonListener = new ExitMenuButtonListener();
        exit.addActionListener(exitMenuButtonListener);
        AboutMenuActionListener aboutMenuActionListener = new AboutMenuActionListener();
        information.addActionListener(aboutMenuActionListener);

        menu.add(exit);
        aboutProgram.add(information);
        menuBar.add(menu);
        menuBar.add(aboutProgram);

        setJMenuBar(menuBar);
        setVisible(true);


    }

}
