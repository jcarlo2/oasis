package oasys.view.admin.student;

import lombok.Getter;
import oasys.customcomponent.jtable.CustomJTable;

import javax.swing.*;
import java.awt.*;

@Getter
public class Student extends JPanel {
    String[] columnName = {"Name","Advisory Section","ID"};
    private final CustomJTable table = new CustomJTable(columnName);
    private final JScrollPane scroll = new JScrollPane(table);
    private final JPanel wrapper = new JPanel();
    private final JButton add = new JButton("Add");
    private final JButton remove = new JButton("Remove");

    private final JTextField studentNameField = new JTextField(15);
    private final JTextField classSectionField = new JTextField(15);
    private final JTextField idField = new JTextField(15);
    private int result;


    public Student() {
        setLayout(new BorderLayout());
        wrapper.setLayout(new BorderLayout());
        add.setBackground(Color.GREEN);
        remove.setBackground(Color.RED);
        wrapper.add(remove,BorderLayout.EAST);
        wrapper.add(add,BorderLayout.WEST);
        add(scroll,BorderLayout.CENTER);
        add(wrapper,BorderLayout.SOUTH);

        setOptionPane();
    }

    private void setOptionPane() {
        add.addActionListener(e -> {
            String message = "Enter Student Name, Section, Id";
            result = JOptionPane.showOptionDialog(new Frame(), new Object[] {message,
                            studentNameField, classSectionField, idField},
                    "Add Student", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
        });
    }
}

