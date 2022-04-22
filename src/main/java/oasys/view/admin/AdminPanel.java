package oasys.view.admin;

import oasys.view.admin.account.Account;
import oasys.view.admin.classroom.Classroom;
import oasys.view.admin.student.Student;
import oasys.view.admin.teacher.Teacher;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private final Account account = new Account();
    private final Teacher teacher = new Teacher();
    private final Student student = new Student();
    private final Classroom classroom = new Classroom();
    private final JPanel center = new JPanel();
    private final JPanel west = new JPanel();
    private final JButton accountBtn = new JButton("Account");
    private final JButton teacherBtn = new JButton("Teacher");
    private final JButton studentBtn = new JButton("        Student        ");
    private final JButton classroomBtn = new JButton("Classroom");
    private final CardLayout card = new CardLayout();

    public AdminPanel() {
        setMinimumSize(new Dimension(800,600));
        setPreferredSize(new Dimension(800,600));
        setLayout(new BorderLayout());

        accountBtn.setEnabled(false);

        setWest();
        setCenter();
        addActionListener();

        add(west,BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
    }

    private void addActionListener() {
        accountBtn.addActionListener(e -> {
            card.show(center,"account");
            accountBtn.setEnabled(false);
            teacherBtn.setEnabled(true);
            studentBtn.setEnabled(true);
            classroomBtn.setEnabled(true);
        });

        teacherBtn.addActionListener(e -> {
            card.show(center,"teacher");
            accountBtn.setEnabled(true);
            teacherBtn.setEnabled(false);
            studentBtn.setEnabled(true);
            classroomBtn.setEnabled(true);
        });

        studentBtn.addActionListener(e -> {
            card.show(center,"student");
            accountBtn.setEnabled(true);
            teacherBtn.setEnabled(true);
            studentBtn.setEnabled(false);
            classroomBtn.setEnabled(true);
        });

        classroomBtn.addActionListener(e -> {
            card.show(center,"classroom");
            accountBtn.setEnabled(true);
            teacherBtn.setEnabled(true);
            studentBtn.setEnabled(true);
            classroomBtn.setEnabled(false);
        });
    }

    private void setCenter() {
        center.setLayout(card);
        center.add(account,"account");
        center.add(teacher,"teacher");
        center.add(student,"student");
        center.add(classroom,"classroom");
        card.show(center,"account");
    }

    private void setWest() {
        west.setLayout(new GridLayout(4,1));
        west.add(accountBtn);
        west.add(teacherBtn);
        west.add(studentBtn);
        west.add(classroomBtn);
    }
}
