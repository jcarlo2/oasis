package oasys.view.student.panel.account;

import lombok.Getter;
import oasys.customcomponent.StudentJTable;
import oasys.util.Constant;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
public class Account extends JPanel {
    private final JPanel informationPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();
    private final JPanel picturePanel = new JPanel();
    private final JLabel picture = new JLabel();
    private final StudentJTable table = new StudentJTable();
    private final JButton mailBox = new JButton("Mail Box");
    private final JButton logOut = new JButton("Log Out");


    public Account() {
        setLayout(new GridLayout(2,1));
        setPicturePanel();
        setInformationPanel();

        add(picturePanel);
        add(informationPanel);
    }

    private void setInformationPanel() {
        informationPanel.setBackground(Constant.COLOR_BLUE);
        informationPanel.setLayout(new BorderLayout());

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Constant.COLOR_BLUE);
        bottomPanel.add(mailBox,BorderLayout.WEST);
        bottomPanel.add(logOut,BorderLayout.EAST);

        informationPanel.add(table,BorderLayout.CENTER);
        informationPanel.add(bottomPanel,BorderLayout.SOUTH);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/haha.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        picture.setIcon(icon);

        picturePanel.setBackground(Constant.COLOR_BLUE);
        picturePanel.setLayout(new GridBagLayout());
        picturePanel.add(picture);
    }
}
