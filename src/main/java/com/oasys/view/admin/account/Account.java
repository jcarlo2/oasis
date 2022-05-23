package com.oasys.view.admin.account;

import lombok.Getter;
import com.oasys.shared.util.ConstantString;

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
    private final DefaultTableModel model = new DefaultTableModel(0,2);
    private final JTable table = new JTable(model);
    private final JButton logOut = new JButton("Log Out");


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

        model.addRow(new String[]{"Name","Abriol, Joshua GWAPO"});
        model.addRow(new String[]{"Email","akosiabriolgwapo@gmail.com"});
        model.addRow(new String[]{"Campus","STI College Fairview"});
        model.addRow(new String[]{"Academic Level","Secondary"});
        model.addRow(new String[]{"Section","ICT-103"});
        model.addRow(new String[]{"Program","Information and Communications Technology"});
        model.addRow(new String[]{"Year Level","Grade 11"});
        model.addRow(new String[]{"Student ID","1234567890"});
        table.setBackground(ConstantString.COLOR_BLUE);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,renderer); // CENTER TEXT
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setDefaultEditor(Object.class,null); // DISABLE EDIT setEditable(false)

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(ConstantString.COLOR_BLUE);
        bottomPanel.add(logOut,BorderLayout.EAST);

        informationPanel.add(table,BorderLayout.CENTER);
        informationPanel.add(bottomPanel,BorderLayout.SOUTH);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/haha.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        picture.setIcon(icon);

        picturePanel.setBackground(ConstantString.COLOR_BLUE);
        picturePanel.setLayout(new GridBagLayout());
        picturePanel.add(picture);
    }
}
