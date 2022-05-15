package oasys.view.student;

import lombok.Getter;

import javax.swing.*;

@Getter
public class StudentFrame extends  JFrame{
    private final StudentPanel studentPanel = new StudentPanel();
    public StudentFrame() {
        super("OASYS");
        add(studentPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
