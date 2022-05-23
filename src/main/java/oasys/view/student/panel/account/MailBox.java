package oasys.view.student.panel.account;

import lombok.Getter;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.JPanelBlueBackground;
import oasys.customcomponent.jtable.MailboxJTable;

import javax.swing.*;
import java.awt.*;

import static oasys.util.ConstantString.COLOR_BLUE;

@Getter
public class MailBox extends CustomJPanel {
    private final String[] columnName = {"No.", "Status","Subject","Type","Report Id","Adviser"};
    private final MailboxJTable table = new MailboxJTable(columnName);
    private final JScrollPane scroll = new JScrollPane(table);
    private final JButton back = new JButton("Back");
    private final JPanelBlueBackground wrapper = new JPanelBlueBackground();

    public MailBox() {
        table.setBackground(COLOR_BLUE);
        back.setBackground(Color.RED);
        wrapper.setLayout(new GridBagLayout());
        wrapper.add(back);
        add(scroll,BorderLayout.CENTER);
        add(wrapper,BorderLayout.SOUTH);
    }
}
