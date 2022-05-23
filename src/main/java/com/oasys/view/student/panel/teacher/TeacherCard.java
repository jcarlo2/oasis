package com.oasys.view.student.panel.teacher;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class TeacherCard extends JPanel {
    private final CardLayout card = new CardLayout();
    private final Teacher teacher = new Teacher();
    private final Concern concern = new Concern();

    public TeacherCard() {
        setLayout(card);
        add("teacher",teacher);
        add("concern",concern);
        card.show(this,"teacher");
    }
}
