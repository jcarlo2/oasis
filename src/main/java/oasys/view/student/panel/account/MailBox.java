package oasys.view.student.panel.account;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MailBox extends JPanel {
    private final JList<String> list = new JList<>();
    private final JScrollPane scroll = new JScrollPane(list);
    private final JButton back = new JButton("Back");

    public MailBox() {
        setLayout(new BorderLayout());
        add(scroll,BorderLayout.CENTER);
        add(back,BorderLayout.SOUTH);
    }
}
