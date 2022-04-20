package oasys.view.student;

import javax.swing.*;

public class StudentFrame extends  JFrame{
    public StudentFrame() {
        super("OASYS");
        add(new StudentPanel());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
