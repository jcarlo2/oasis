package com.oasys.view.student;

import com.oasys.view.student.panel.account.AccountCard;
import com.oasys.view.student.panel.dashboard.DashboardCard;
import com.oasys.view.student.panel.teacher.TeacherCard;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class StudentPanel extends JPanel {
    private final AccountCard account = new AccountCard();
    private final DashboardCard dashboard = new DashboardCard();
    private final TeacherCard teacher = new TeacherCard();
    private final JPanel center = new JPanel();
    private final JPanel west = new JPanel();
    private final JButton accountBtn = new JButton("        Account        ");
    private final JButton dashboardBtn = new JButton("        Dashboard        ");
    private final JButton teacherBtn = new JButton("        Teacher        ");
    private final CardLayout card = new CardLayout();

    public StudentPanel() {
        setMinimumSize(new Dimension(800,600));
        setPreferredSize(new Dimension(800,600));
        setLayout(new BorderLayout());

        accountBtn.setEnabled(false);

        setWest();
        setCenter();

        add(west,BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
    }

    private void setCenter() {
        center.setLayout(card);
        center.add(account,"account");
        center.add(dashboard,"dashboard");
        center.add(teacher,"teacher");
        card.show(center,"account");
    }

    private void setWest() {
        west.setLayout(new GridLayout(3,1));
        west.add(accountBtn);
        west.add(dashboardBtn);
        west.add(teacherBtn);
    }
}
