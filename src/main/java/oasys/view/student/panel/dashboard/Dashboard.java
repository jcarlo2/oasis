package oasys.view.student.panel.dashboard;

import lombok.Getter;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.CustomJTextPane;

import java.awt.*;
import java.util.ArrayList;

@Getter
public class Dashboard extends CustomJPanel {
    private final ArrayList<CustomJTextPane> dashList = new ArrayList<>();
    private final CustomJTextPane dashOne = new CustomJTextPane(true,false);
    private final CustomJTextPane dashTwo = new CustomJTextPane(true,false);
    private final CustomJTextPane dashThree = new CustomJTextPane(true,false);
    private final CustomJTextPane dashFour = new CustomJTextPane(true,false);
    private final CustomJTextPane dashFive = new CustomJTextPane(true,false);
    private final CustomJTextPane dashSix = new CustomJTextPane(true,false);

    public Dashboard() {
        final GridLayout grid = new GridLayout(3,2);
        grid.setHgap(5);
        grid.setVgap(5);
        setLayout(grid);
        setDashList();
        add(dashOne);
        add(dashTwo);
        add(dashThree);
        add(dashFour);
        add(dashFive);
        add(dashSix);
    }

    private void setDashList(){
        dashList.add(dashOne);
        dashList.add(dashTwo);
        dashList.add(dashThree);
        dashList.add(dashFour);
        dashList.add(dashFive);
        dashList.add(dashSix);
    }
}
