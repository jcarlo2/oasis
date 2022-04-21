package oasys.view.student.panel.dashboard;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
public class DashboardCard extends JPanel {
    private final CardLayout card = new CardLayout();
    private final AnnouncementBoard announcementBoard = new AnnouncementBoard();
    private final Dashboard dashboard = new Dashboard();

    public DashboardCard() {
        setLayout(card);
        add("dashboard",dashboard);
        add("announcement",announcementBoard);
        card.show(this,"dashboard");
        addListener();
    }

    private void addListener() {
        announcementBoard.getBack().addActionListener(e -> card.show(this,"dashboard"));

        dashboard.getDashOne().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"announcement");
                }
            }
        });

        dashboard.getDashTwo().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"announcement");
                }
            }
        });

        dashboard.getDashThree().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"announcement");
                }
            }
        });

        dashboard.getDashFour().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"announcement");
                }
            }
        });

        dashboard.getDashFive().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"announcement");
                }
            }
        });

        dashboard.getDashSix().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"announcement");
                }
            }
        });
    }
}
