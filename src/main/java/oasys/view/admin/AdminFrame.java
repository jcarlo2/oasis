package oasys.view.admin;

import lombok.Getter;

import javax.swing.*;

@Getter
public class AdminFrame extends  JFrame{
    private final AdminPanel adminPanel = new AdminPanel();
    public AdminFrame() {
        super("OASYS");
        add(adminPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
