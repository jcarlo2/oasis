package oasys.view.teacher.panel.classroom;

import lombok.Getter;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.CustomJTextPane;
import oasys.customcomponent.CustomJList;

import javax.swing.*;
import java.awt.*;

import static oasys.util.ConstantString.COLOR_BLUE;

@Getter
public class Classroom extends CustomJPanel {
    private final CustomJTextPane section = new CustomJTextPane(true,false, "Section List");
    private final CustomJList list = new CustomJList();
    private final JScrollPane scroll = new JScrollPane(list);

    public Classroom() {
        list.setBackground(COLOR_BLUE);
        add(section,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
    }
}

