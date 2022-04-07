package oasys.view.login;

import oasys.view.Constant;

import javax.swing.*;
import java.awt.*;

public class LogInPanel extends JPanel {
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JPanel logInOption = new JPanel();

    private final JLabel logo = new JLabel();
    private final JTextField username = new JTextField("Username",15);
    private final JPasswordField password = new JPasswordField("Password",15);
    private final JButton logBtn = new JButton("Log In");
    private final JRadioButton admin = new JRadioButton("admin");
    private final JRadioButton student = new JRadioButton("student");
    private final JRadioButton teacher = new JRadioButton("teacher");
    private final ButtonGroup group = new ButtonGroup();



    public LogInPanel() {
        setPreferredSize(new Dimension(650,400));
        setLayout(new GridLayout(2,1));

        setLogoPanel();
        setInputPanel();

        add(logoPanel);
        add(inputPanel);
    }

    public void setLogoPanel() {
        logoPanel.setBackground(Constant.COLOR_BLUE);
        logoPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        ImageIcon icon = new ImageIcon("src/main/resources/images/oasys.png");
        logo.setIcon(icon);

        constraints.anchor = GridBagConstraints.CENTER;
        logoPanel.add(logo,constraints);
    }

    public void setInputPanel() {
        inputPanel.setBackground(Constant.COLOR_BLUE);
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(2,2,2,2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        inputPanel.add(username,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        inputPanel.add(password,constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        inputPanel.add(logBtn,constraints);

        logInOption.setLayout(new GridLayout(1,3));
        group.add(admin);
        group.add(student);
        group.add(teacher);
        logInOption.add(admin);
        logInOption.add(student);
        logInOption.add(teacher);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 3;
        inputPanel.add(logInOption,constraints);

    }
}
