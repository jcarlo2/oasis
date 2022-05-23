package com.oasys.view.teacher.panel.dashboard;

import com.oasys.shared.customcomponent.jpanel.JPanelBlueBackground;
import lombok.Getter;
import com.oasys.shared.customcomponent.jpanel.CustomJPanel;
import com.oasys.shared.customcomponent.CustomJTextPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
public class Dashboard extends CustomJPanel {
    private final JPanelBlueBackground wrapper1 = new JPanelBlueBackground();
    private final CustomJTextPane dashOne = new CustomJTextPane(true,false);
    private final CustomJTextPane dashTwo = new CustomJTextPane(true,false);
    private final CustomJTextPane dashThree = new CustomJTextPane(true,false);
    private final CustomJTextPane dashFour = new CustomJTextPane(true,false);
    private final CustomJTextPane dashFive = new CustomJTextPane(true,false);
    private final CustomJTextPane dashSix = new CustomJTextPane(true,false);
    private final ArrayList<CustomJTextPane> dashList = new ArrayList<>();

    private final JPanelBlueBackground wrapper2 = new JPanelBlueBackground();
    private final JButton post = new JButton("Create New Post");
    private final JButton delete = new JButton("Delete");

    public Dashboard() {
        addDashList();
        setWrapper1();
        setWrapper2();
        add(wrapper1,BorderLayout.CENTER);
        add(wrapper2,BorderLayout.NORTH);
    }

    private void addDashList() {
        dashList.add(dashOne);
        dashList.add(dashTwo);
        dashList.add(dashThree);
        dashList.add(dashFour);
        dashList.add(dashFive);
        dashList.add(dashSix);
    }

    private void setWrapper2() {
        wrapper2.setLayout(new GridLayout(1,2));
        wrapper2.add(post);
        wrapper2.add(delete);
    }

    private void setWrapper1() {
        final GridLayout grid = new GridLayout(3,2);
        grid.setHgap(5);
        grid.setVgap(5);
        wrapper1.setLayout(grid);
        wrapper1.add(dashOne);
        wrapper1.add(dashTwo);
        wrapper1.add(dashThree);
        wrapper1.add(dashFour);
        wrapper1.add(dashFive);
        wrapper1.add(dashSix);
    }
}
