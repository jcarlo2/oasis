package oasys.view.login;


import lombok.Getter;
import oasys.util.TableCreator;

import javax.swing.*;

@Getter
public class LogInFrame extends JFrame implements TableCreator {
    private final LogInPanel logInPanel = new LogInPanel();
    public LogInFrame() {

        add(logInPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
