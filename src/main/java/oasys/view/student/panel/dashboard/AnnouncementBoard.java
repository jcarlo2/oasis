package oasys.view.student.panel.dashboard;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class AnnouncementBoard extends JPanel {
    private final JButton back = new JButton("Back");
    private final JTextArea textArea = new JTextArea("ANNOUNCEMENT BOARD");

    public AnnouncementBoard() {
        setLayout(new BorderLayout());
        add(textArea,BorderLayout.CENTER);
        add(back,BorderLayout.SOUTH);
    }
}
