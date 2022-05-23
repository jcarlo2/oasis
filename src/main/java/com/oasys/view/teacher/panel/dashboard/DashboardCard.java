package com.oasys.view.teacher.panel.dashboard;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class DashboardCard extends JPanel {
    private final Dashboard dashboard = new Dashboard();
    private final AddDashboard addDashboard = new AddDashboard();
    private final AnnouncementBoard announcementBoard = new AnnouncementBoard();
    private final CardLayout card = new CardLayout();

    public DashboardCard() {
        setLayout(card);
        add("dashboard",dashboard);
        add("add",addDashboard);
        add("announcement",announcementBoard);
        card.show(this,"dashboard");
    }
}
