package oasys.view.student.panel.dashboard;

import lombok.Getter;
import oasys.customcomponent.CustomJTextArea;

import javax.swing.*;
import java.awt.*;

@Getter
public class Dashboard extends JPanel {
    private final CustomJTextArea dashOne = new CustomJTextArea("Dash One");
    private final CustomJTextArea dashTwo = new CustomJTextArea("Dash Two");
    private final CustomJTextArea dashThree = new CustomJTextArea("Dash Three");
    private final CustomJTextArea dashFour = new CustomJTextArea("Dash Four");
    private final CustomJTextArea dashFive = new CustomJTextArea("Dash Five");
    private final CustomJTextArea dashSix = new CustomJTextArea("Dash Six");

    public Dashboard() {
        setLayout(new GridLayout(3,2));
        add(dashOne);
        add(dashTwo);
        add(dashThree);
        add(dashFour);
        add(dashFive);
        add(dashSix);
    }
}
