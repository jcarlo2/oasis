package oasys.view.teacher;

import oasys.view.student.StudentPanel;

import javax.swing.*;

public class TeacherFrame extends  JFrame{
    public TeacherFrame() {
        add(new TeacherPanel());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
