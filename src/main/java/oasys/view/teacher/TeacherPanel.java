package oasys.view.teacher;

import oasys.view.teacher.panel.Account;
import oasys.view.teacher.panel.Dashboard;
import oasys.view.teacher.panel.Classroom;

import javax.swing.*;
import java.awt.*;

public class TeacherPanel extends JPanel {
    private final Account account = new Account();
    private final Dashboard dashboard = new Dashboard();
    private final Classroom classroom = new Classroom();
    private final JPanel center = new JPanel();
    private final JPanel west = new JPanel();
    private final JButton accountBtn = new JButton("        Account        ");
    private final JButton dashboardBtn = new JButton("        Dashboard        ");
    private final JButton teacherBtn = new JButton("        Classroom        ");
    private final CardLayout card = new CardLayout();

    public TeacherPanel() {
        setMinimumSize(new Dimension(600,400));
        setPreferredSize(new Dimension(600,400));
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
        center.add(dashboard,"dashboard");
        center.add(classroom,"classroom");
        card.show(center,"account");
    }

    private void setWest() {
        west.setLayout(new GridLayout(3,1));
        west.add(accountBtn);
        west.add(dashboardBtn);
        west.add(teacherBtn);
    }
}
