package oasys.view.admin;

import javax.swing.*;

public class AdminFrame extends  JFrame{
    public AdminFrame() {
        super("OASYS");
        add(new AdminPanel());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
