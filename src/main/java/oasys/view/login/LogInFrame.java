package oasys.view.login;


import javax.swing.*;

public class LogInFrame extends JFrame  {
    public LogInFrame() {

        add(new LogInPanel());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
