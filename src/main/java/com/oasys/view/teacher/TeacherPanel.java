package com.oasys.view.teacher;

import com.oasys.view.teacher.panel.dashboard.DashboardCard;
import lombok.Getter;
import com.oasys.view.teacher.panel.account.Account;
import com.oasys.view.teacher.panel.classroom.ClassroomCard;

import javax.swing.*;
import java.awt.*;

@Getter
public class TeacherPanel extends JPanel {
    private final Account account = new Account();
    private final DashboardCard dashboardCard = new DashboardCard();
    private final ClassroomCard classroomCard = new ClassroomCard();
    private final JPanel center = new JPanel();
    private final JPanel west = new JPanel();
    private final JButton accountBtn = new JButton("        Account        ");
    private final JButton dashboardBtn = new JButton("        Dashboard        ");
    private final JButton teacherBtn = new JButton("        Classroom        ");
    private final CardLayout card = new CardLayout();

    public TeacherPanel() {
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
            if(e.getSource() == accountBtn) {
                card.show(center,"account");
                accountBtn.setEnabled(false);
                dashboardBtn.setEnabled(true);
                teacherBtn.setEnabled(true);
            }
        });

        dashboardBtn.addActionListener(e -> {
            if(e.getSource() == dashboardBtn) {
                card.show(center,"dashboard");
                accountBtn.setEnabled(true);
                dashboardBtn.setEnabled(false);
                teacherBtn.setEnabled(true);
            }
        });

        teacherBtn.addActionListener(e -> {
            if(e.getSource() == teacherBtn) {
                card.show(center,"classroom");
                accountBtn.setEnabled(true);
                dashboardBtn.setEnabled(true);
                teacherBtn.setEnabled(false);
            }
        });
    }

    private void setCenter() {
        center.setLayout(card);
        center.add(account,"account");
        center.add(dashboardCard,"dashboard");
        center.add(classroomCard,"classroom");
        card.show(center,"account");
    }

    private void setWest() {
        west.setLayout(new GridLayout(3,1));
        west.add(accountBtn);
        west.add(dashboardBtn);
        west.add(teacherBtn);
    }
}
