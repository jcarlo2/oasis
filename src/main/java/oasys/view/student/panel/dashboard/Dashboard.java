package oasys.view.student.panel.dashboard;

import lombok.Getter;
import oasys.customcomponent.CustomJTextPane;

import javax.swing.*;
import java.awt.*;

@Getter
public class Dashboard extends JPanel {
    private final CustomJTextPane dashOne = new CustomJTextPane(true);
    private final CustomJTextPane dashTwo = new CustomJTextPane(true);
    private final CustomJTextPane dashThree = new CustomJTextPane(true);
    private final CustomJTextPane dashFour = new CustomJTextPane(true);
    private final CustomJTextPane dashFive = new CustomJTextPane(true);
    private final CustomJTextPane dashSix = new CustomJTextPane(true);

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
