package oasys.view.teacher.panel;

import oasys.view.Constant;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Account extends JPanel {
    private final JPanel informationPanel = new JPanel();
    private final JPanel logoutPanel = new JPanel();
    private final JPanel picturePanel = new JPanel();
    private final JLabel picture = new JLabel();
    private final DefaultTableModel model = new DefaultTableModel(0,2);
    private final JTable table = new JTable(model);
    private final JButton logout = new JButton("Log Out");


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

        model.addRow(new String[]{"Name","Rainpuff, Pomu"});
        model.addRow(new String[]{"Email","PomuRainpuff@gmail.com"});
        model.addRow(new String[]{"Campus","STI College Fairview"});
        model.addRow(new String[]{"Department","Information Technology"});
        model.addRow(new String[]{"Advisory Classes","ICT103, STEM301"});
        model.addRow(new String[]{"Consultation Hours","12:30 PM - 2:00 PM"});
        model.addRow(new String[]{"Teacher ID","1234567890"});
        table.setBackground(Constant.COLOR_BLUE);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,renderer); // CENTER TEXT
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setDefaultEditor(Object.class,null); // DISABLE EDIT setEditable(false)

        logoutPanel.setLayout(new BorderLayout());
        logoutPanel.setBackground(Constant.COLOR_BLUE);
        logoutPanel.add(logout,BorderLayout.EAST);

        informationPanel.add(table,BorderLayout.CENTER);
        informationPanel.add(logoutPanel,BorderLayout.SOUTH);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/im_pomu.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        picture.setIcon(icon);

        picturePanel.setBackground(Constant.COLOR_BLUE);
        picturePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.CENTER;
        picturePanel.add(picture);
    }
}
