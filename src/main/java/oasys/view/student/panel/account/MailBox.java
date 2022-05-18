package oasys.view.student.panel.account;

import lombok.Getter;
import oasys.customcomponent.jtable.CustomJTable;

import javax.swing.*;
import java.awt.*;

@Getter
public class MailBox extends JPanel {
    private final String[] columnName = {"No.", "Student","Adviser","Subject","Report Id","Status"};
    private final CustomJTable table = new CustomJTable(columnName,true);
    private final JScrollPane scroll = new JScrollPane(table);
    private final JButton back = new JButton("Back");

    public MailBox() {
        setLayout(new BorderLayout());
        add(scroll,BorderLayout.CENTER);
        add(back,BorderLayout.SOUTH);
    }
}
