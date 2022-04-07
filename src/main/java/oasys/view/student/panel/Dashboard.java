package oasys.view.student.panel;

import oasys.model.CustomJTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JPanel {
    private final CardLayout card = new CardLayout();
    private final JPanel mainPanel = new JPanel();
    private final JPanel announcementOnePanel = new JPanel();
    private final JPanel announcementTwoPanel = new JPanel();
    private final JPanel announcementThreePanel = new JPanel();
    private final JPanel announcementFourPanel = new JPanel();
    private final JPanel announcementFivePanel = new JPanel();
    private final JPanel announcementSixPanel = new JPanel();

    private final CustomJTextArea announcementOne = new CustomJTextArea();
    private final CustomJTextArea announcementTwo = new CustomJTextArea();
    private final CustomJTextArea announcementThree = new CustomJTextArea();
    private final CustomJTextArea announcementFour = new CustomJTextArea();
    private final CustomJTextArea announcementFive = new CustomJTextArea();
    private final CustomJTextArea announcementSix = new CustomJTextArea();

    private final CustomJTextArea fullAnnouncementOne = new CustomJTextArea("ONE");
    private final CustomJTextArea fullAnnouncementTwo = new CustomJTextArea();
    private final CustomJTextArea fullAnnouncementThree = new CustomJTextArea();
    private final CustomJTextArea fullAnnouncementFour = new CustomJTextArea();
    private final CustomJTextArea fullAnnouncementFive = new CustomJTextArea();
    private final CustomJTextArea fullAnnouncementSix = new CustomJTextArea();

    private final JButton back1 = new JButton("Back");
    private final JButton back2 = new JButton("Back");
    private final JButton back3 = new JButton("Back");
    private final JButton back4 = new JButton("Back");
    private final JButton back5 = new JButton("Back");
    private final JButton back6 = new JButton("Back");

    public Dashboard() {
        addEventListener();
        setAnnouncementPanel();
        setJTextArea();
        setCard();
    }

    public void setJTextArea() {
        mainPanel.setLayout(new GridLayout(3,2));
        mainPanel.add(announcementOne);
        mainPanel.add(announcementTwo);
        mainPanel.add(announcementThree);
        mainPanel.add(announcementFour);
        mainPanel.add(announcementFive);
        mainPanel.add(announcementSix);
    }

    public void setCard() {
        setLayout(card);
        add("one", announcementOnePanel);
        add("two", announcementTwoPanel);
        add("three", announcementThreePanel);
        add("four", announcementFourPanel);
        add("five", announcementFivePanel);
        add("six", announcementSixPanel);
        add("announcement", mainPanel);
        card.show(this,"announcement");
    }

    public void addEventListener() {
        announcementOne.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(), "one");
                }
            }
        });

        announcementTwo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"two");
                }
            }
        });

        announcementThree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"three");
                }
            }
        });

        announcementFour.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"four");
                }
            }
        });

        announcementFive.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"five");
                }
            }
        });

        announcementSix.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    card.show(e.getComponent().getParent().getParent(),"six");
                }
            }
        });

        back1.addActionListener(e -> card.show(this, "announcement"));
        back2.addActionListener(e -> card.show(this, "announcement"));
        back3.addActionListener(e -> card.show(this, "announcement"));
        back4.addActionListener(e -> card.show(this, "announcement"));
        back5.addActionListener(e -> card.show(this, "announcement"));
        back6.addActionListener(e -> card.show(this, "announcement"));
    }

    public void setAnnouncementPanel() {
        announcementOnePanel.setLayout(new BorderLayout());
        announcementOnePanel.add(fullAnnouncementOne,BorderLayout.CENTER);
        announcementOnePanel.add(back1,BorderLayout.SOUTH);

        announcementTwoPanel.setLayout(new BorderLayout());
        announcementTwoPanel.add(fullAnnouncementTwo,BorderLayout.CENTER);
        announcementTwoPanel.add(back2,BorderLayout.SOUTH);

        announcementThreePanel.setLayout(new BorderLayout());
        announcementThreePanel.add(fullAnnouncementThree,BorderLayout.CENTER);
        announcementThreePanel.add(back3,BorderLayout.SOUTH);

        announcementFourPanel.setLayout(new BorderLayout());
        announcementFourPanel.add(fullAnnouncementFour,BorderLayout.CENTER);
        announcementFourPanel.add(back4,BorderLayout.SOUTH);

        announcementFivePanel.setLayout(new BorderLayout());
        announcementFivePanel.add(fullAnnouncementFive,BorderLayout.CENTER);
        announcementFivePanel.add(back5,BorderLayout.SOUTH);

        announcementSixPanel.setLayout(new BorderLayout());
        announcementSixPanel.add(fullAnnouncementSix,BorderLayout.CENTER);
        announcementSixPanel.add(back6,BorderLayout.SOUTH);
    }
}
