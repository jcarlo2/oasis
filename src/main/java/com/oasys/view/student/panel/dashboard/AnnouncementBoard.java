package com.oasys.view.student.panel.dashboard;

import com.oasys.shared.customcomponent.jpanel.CustomJPanel;
import com.oasys.shared.customcomponent.jpanel.JPanelBlueBackground;
import lombok.Getter;
import com.oasys.shared.customcomponent.CustomJTextPane;

import javax.swing.*;
import java.awt.*;

@Getter
public class AnnouncementBoard extends CustomJPanel {
    private final JPanelBlueBackground wrapper = new JPanelBlueBackground();
    private final Icon nextIcon = new ImageIcon("src/main/resources/images/next.png");
    private final Icon prevIcon = new ImageIcon("src/main/resources/images/previous.png");
    private final JButton back = new JButton("Back");
    private final JButton next = new JButton(nextIcon);
    private final JButton previous = new JButton(prevIcon);
    private final CustomJTextPane textArea = new CustomJTextPane( false,false);
    private final CustomJTextPane title = new CustomJTextPane( true,false);

    public AnnouncementBoard() {
        setWrapper();
        add(title,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);
        add(wrapper,BorderLayout.SOUTH);
    }

    private void setWrapper() {
        wrapper.setLayout(new GridLayout(1,3));
        wrapper.add(back);
        wrapper.add(previous);
        wrapper.add(next);
    }
}
