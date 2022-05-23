package com.oasys.view.student.panel.teacher;

import com.oasys.shared.customcomponent.jpanel.JPanelBlueBackground;
import lombok.Getter;
import com.oasys.shared.customcomponent.CustomJTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

@Getter
public class Teacher extends JPanelBlueBackground {
    private final JPanelBlueBackground wrapper1 = new JPanelBlueBackground();
    private final JPanelBlueBackground wrapper2 = new JPanelBlueBackground();
    private final JLabel label = new JLabel();
    private final CustomJTextField teacherName = new CustomJTextField("Teacher",false, Color.YELLOW);
    private final JButton concernBtn = new JButton("Raise A Concern");
    public Teacher() {
        setLayout(new GridLayout(2,1));
        setWrapper1();
        setWrapper2();
        add(wrapper1);
        add(wrapper2);
    }

    private void setWrapper2() {
        teacherName.setText("Ariana Grande");
        concernBtn.setBackground(Color.GREEN);
        teacherName.setBackground(Color.YELLOW);
        wrapper2.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2,2,2,2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        wrapper2.add(teacherName,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        wrapper2.add(concernBtn,constraints);
    }

    private void setWrapper1() {
        wrapper1.setLayout(new GridBagLayout());
        label.setIcon(setPicture());
        wrapper1.add(label);
    }

    private @NotNull ImageIcon setPicture() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/haha.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        return icon;
    }
}
