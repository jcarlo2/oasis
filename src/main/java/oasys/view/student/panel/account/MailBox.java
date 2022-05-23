package oasys.view.student.panel.account;

import lombok.Getter;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.jtable.MailboxJTable;

import javax.swing.*;
import java.awt.*;

@Getter
public class MailBox extends CustomJPanel {
    private final String[] columnName = {"No.", "Status","Subject","Type","Report Id","Adviser"};
    private final MailboxJTable table = new MailboxJTable(columnName);
    private final JScrollPane scroll = new JScrollPane(table);
    private final JButton back = new JButton("Back");

    public MailBox() {
        add(scroll,BorderLayout.CENTER);
        add(back,BorderLayout.SOUTH);
    }
}
