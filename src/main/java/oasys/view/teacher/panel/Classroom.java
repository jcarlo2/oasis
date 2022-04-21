package oasys.view.teacher.panel;

import oasys.view.Constant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Classroom extends JPanel {
    private final JPanel navigationPanel = new JPanel();
    private final JPanel customJList = new JPanel();



    public Classroom() {
        setLayout(new GridLayout(1,1));

        setNavigationPanel();
        add(navigationPanel);
    }
        private void setNavigationPanel(){
            navigationPanel.setBackground(Constant.COLOR_BLUE);
            navigationPanel.setLayout(new BorderLayout());

            String students[] = {
                    "Finana Ryugu",
                    "Elira Pendora",
                    "Selen Tatsuki",
                    "Petra Gurin",
                    "Rosemi Lockheart",
                    "Nina Kosaka",
                    "Millie Parfait",
                    "Enna Alouette",
                    "Reimu Endou"
            };

            JList student = new JList(students);
            customJList.add(student);
            customJList.setBackground(Constant.COLOR_BLUE);
        navigationPanel.add(customJList, BorderLayout.WEST);

        }
    }

