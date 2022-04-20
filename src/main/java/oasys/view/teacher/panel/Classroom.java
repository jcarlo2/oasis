package oasys.view.teacher.panel;

import oasys.view.Constant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Classroom extends JPanel {
    private final JPanel navigationPanel = new JPanel(new BorderLayout());
    private final JPanel layout = new JPanel(new GridBagLayout());
    private final JPanel btnPanel = new JPanel(new GridLayout(0, 3, 5, 5));
    private final JButton elira = new JButton("<html><center><i>Elira Pendora</i><br><b>Student</b></center></html>");
    private final JButton finana = new JButton("<html><center><i>Finana Ryugu</i><br><b>Student</b></center></html>");
    private final JButton selen = new JButton("<html><center><i>Selen Tatsuki</i><br><b>Student</b></center></html>");
    private final JButton rosemi = new JButton("<html><center><i>Rosemi Lovelock</i><br><b>Student</b></center></html>");
    private final JButton petra = new JButton("<html><center><i>Petra Gurin</i><br><b>Student</b></center></html>");
    private final JButton nina = new JButton("<html><center><i>Nina Kosaka</i><br><b>Student</b></center></html>");
    private final JButton millie = new JButton("<html><center><i>Millie Parfait</i><br><b>Student</b></center></html>");
    private final JButton enna = new JButton("<html><center><i>Enna Alouette</i><br><b>Student</b></center></html>");
    private final JButton reimu = new JButton("<html><center><i>Reimu Endou</i><br><b>Student</b></center></html>");
    private final JButton mysta = new JButton("<html><center><i>Mysta Rias</i><br><b>Student</b></center></html>");
    private final JButton vox = new JButton("<html><center><i>Vox Akuma</i><br><b>Student</b></center></html>");
    private final JButton luca = new JButton("<html><center><i>Luca Kaneshiro</i><br><b>Student</b></center></html>");
    private final JButton shu = new JButton("<html><center><i>Shu Yamino</i><br><b>Student</b></center></html>");
    private final JButton ike = new JButton("<html><center><i>Ike Eveland</i><br><b>Student</b></center></html>");
    private final JButton sonny = new JButton("<html><center><i>Sonny Brisko</i><br><b>Student</b></center></html>");
    private final JButton uki = new JButton("<html><center><i>Uki Violeta</i><br><b>Student</b></center></html>");
    private final JButton yugo = new JButton("<html><center><i>Yugo Asuma</i><br><b>Student</b></center></html>");
    private final JButton fulgur = new JButton("<html><center><i>Fulgur Ovid</i><br><b>Student</b></center></html>");
    private final JButton alban = new JButton("<html><center><i>Alban Knox</i><br><b>Student</b></center></html>");


    public Classroom() {
        navigationPanel.setBorder(new EmptyBorder(2, 3, 2, 3));
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        setNavigationPanel();
        add(navigationPanel);
    }
        private void setNavigationPanel(){
            btnPanel.add(elira);
            btnPanel.add(finana);
            btnPanel.add(selen);
            btnPanel.add(rosemi);
            btnPanel.add(petra);
            btnPanel.add(nina);
            btnPanel.add(millie);
            btnPanel.add(enna);
            btnPanel.add(reimu);
            btnPanel.add(mysta);
            btnPanel.add(vox);
            btnPanel.add(luca);
            btnPanel.add(ike);
            btnPanel.add(shu);
            btnPanel.add(sonny);
            btnPanel.add(uki);
            btnPanel.add(alban);
            btnPanel.add(fulgur);
            btnPanel.add(yugo);
        layout.add(btnPanel);
        navigationPanel.add(layout, BorderLayout.EAST);
        }
    }

