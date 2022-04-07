package oasys.view.student.panel;

import oasys.view.Constant;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Account extends JPanel {
    private final JPanel informationPanel = new JPanel();
    private final JPanel mailBoxPanel = new JPanel();
    private final JPanel picturePanel = new JPanel();
    private final JLabel picture = new JLabel();
    private final DefaultTableModel model = new DefaultTableModel(0,2);
    private final JTable table = new JTable(model);
    private final JButton mailBox = new JButton("Mail Box");


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

        model.addRow(new String[]{"Name","Abriol, Joshua GWAPO"});
        model.addRow(new String[]{"Email","akosiabriolgwapo@gmail.com"});
        model.addRow(new String[]{"Campus","STI College Fairview"});
        model.addRow(new String[]{"Academic Level","Secondary"});
        model.addRow(new String[]{"Section","ICT-103"});
        model.addRow(new String[]{"Program","Information and Communications Technology"});
        model.addRow(new String[]{"Year Level","Grade 11"});
        model.addRow(new String[]{"Student ID","1234567890"});
        table.setBackground(Constant.COLOR_BLUE);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,renderer); // CENTER TEXT
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setDefaultEditor(Object.class,null); // DISABLE EDIT setEditable(false)

        mailBoxPanel.setLayout(new BorderLayout());
        mailBoxPanel.setBackground(Constant.COLOR_BLUE);
        mailBoxPanel.add(mailBox,BorderLayout.EAST);

        informationPanel.add(table,BorderLayout.CENTER);
        informationPanel.add(mailBoxPanel,BorderLayout.SOUTH);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/haha.png");
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
