package oasys.view.teacher.panel.account;

import lombok.Getter;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.jtable.TeacherJTable;
import oasys.util.ConstantString;

import javax.swing.*;
import java.awt.*;

@Getter
public class Account extends CustomJPanel {
    private final JPanel informationPanel = new JPanel();
    private final JPanel logoutPanel = new JPanel();
    private final JPanel picturePanel = new JPanel();
    private final JLabel picture = new JLabel();
    private final TeacherJTable table = new TeacherJTable();
    private final JButton logout = new JButton("Log Out");


    public Account() {
        setLayout(new GridLayout(2,1));
        setPicturePanel();
        setInformationPanel();
        add(picturePanel);
        add(informationPanel);
    }

    private void setInformationPanel() {
        informationPanel.setBackground(ConstantString.COLOR_BLUE);
        informationPanel.setLayout(new BorderLayout());

        logoutPanel.setLayout(new BorderLayout());
        logoutPanel.setBackground(ConstantString.COLOR_BLUE);
        logoutPanel.add(logout,BorderLayout.EAST);

        informationPanel.add(table,BorderLayout.CENTER);
        informationPanel.add(logoutPanel,BorderLayout.SOUTH);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/im_pomu.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        picture.setIcon(icon);

        picturePanel.setBackground(ConstantString.COLOR_BLUE);
        picturePanel.setLayout(new GridBagLayout());
        picturePanel.add(picture);
    }
}
