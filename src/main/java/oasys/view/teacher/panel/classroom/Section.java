package oasys.view.teacher.panel.classroom;

import lombok.Getter;
import oasys.customcomponent.CustomJList;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.CustomJTextPane;
import oasys.customcomponent.JPanelBlueBackground;

import javax.swing.*;
import java.awt.*;

import static oasys.util.ConstantString.COLOR_BLUE;

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
