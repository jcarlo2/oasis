package com.oasys.view.login;


import com.oasys.shared.util.TableCreator;
import lombok.Getter;

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
