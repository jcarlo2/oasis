package com.oasys.view.admin.classroom;

import lombok.Getter;
import com.oasys.shared.customcomponent.CustomJTextField;

import javax.swing.*;
import java.awt.*;

@Getter
public class Classroom extends JPanel {
    String[] columnName = {"Name","Role","ID"};
    private final JTable table = new JTable();
    private final JScrollPane scroll = new JScrollPane(table);
    private final JPanel wrapper = new JPanel();
    private final JPanel wrapper1 = new JPanel();
    private final CustomJTextField adviserName = new CustomJTextField("Adviser",true);
    private final CustomJTextField section = new CustomJTextField("Section",true);
    private final CustomJTextField student = new CustomJTextField("Student",true);
    private final JButton add = new JButton("Add");
    private final JButton remove = new JButton("Remove");


    public Classroom() {
        setLayout(new BorderLayout());
        add.setBackground(Color.GREEN);
        remove.setBackground(Color.RED);

        wrapper.setLayout(new GridBagLayout());
        wrapper.add(student);
        wrapper.add(adviserName);
        wrapper.add(section);

        wrapper1.setLayout(new BorderLayout());
        wrapper1.add(add,BorderLayout.WEST);
        wrapper1.add(remove,BorderLayout.EAST);

        add(wrapper,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
        add(wrapper1,BorderLayout.SOUTH);
    }
}
