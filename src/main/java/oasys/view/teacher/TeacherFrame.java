package oasys.view.teacher;

import lombok.Getter;

import javax.swing.*;

@Getter
public class TeacherFrame extends  JFrame{
    private final TeacherPanel teacherPanel = new TeacherPanel();
    public TeacherFrame() {
        add(teacherPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
