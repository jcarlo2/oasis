package com.oasys.view.student;

import lombok.Getter;

import javax.swing.*;

@Getter
public class StudentFrame extends  JFrame{
    private final StudentPanel studentPanel = new StudentPanel();
    public StudentFrame() {
        super("OASYS - Student");
        add(studentPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
    }
}
