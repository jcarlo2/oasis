package com.oasys.view.teacher.panel.classroom;

import com.oasys.shared.customcomponent.jpanel.CustomJPanel;
import com.oasys.shared.customcomponent.jpanel.JPanelBlueBackground;
import lombok.Getter;
import com.oasys.shared.customcomponent.CustomJList;
import com.oasys.shared.customcomponent.CustomJTextPane;

import javax.swing.*;
import java.awt.*;

import static com.oasys.shared.util.ConstantString.COLOR_BLUE;

@Getter
public class Section extends CustomJPanel {
    private final CustomJTextPane student = new CustomJTextPane(true,false, "Student List");
    private final CustomJList list = new CustomJList();
    private final JScrollPane scroll = new JScrollPane(list);
    private final JButton back = new JButton("Back");
    private final JPanelBlueBackground wrapper = new JPanelBlueBackground();

    public Section() {
        setWrapper();
        list.setBackground(COLOR_BLUE);
        back.setBackground(Color.RED);
        add(student,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
        add(wrapper,BorderLayout.SOUTH);
    }

    private void setWrapper() {
        wrapper.setLayout(new GridBagLayout());
        wrapper.add(back);
    }
}
