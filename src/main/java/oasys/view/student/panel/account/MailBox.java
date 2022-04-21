package oasys.view.student.panel.account;

import lombok.Getter;
import oasys.customcomponent.CustomJTextArea;

import javax.swing.*;
import java.awt.*;

@Getter
public class MailBox extends JPanel {
    private final CustomJTextArea textArea = new CustomJTextArea("MAIL BOX");
    private final JButton back = new JButton("Back");

    public MailBox() {
        setLayout(new BorderLayout());
        add(textArea,BorderLayout.CENTER);
        add(back,BorderLayout.SOUTH);
    }
}
