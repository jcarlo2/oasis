package oasys.view.login;

import lombok.Getter;
import oasys.util.ConstantString;

import javax.swing.*;
import java.awt.*;

@Getter
public class LogInPanel extends JPanel {
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();

    private final JLabel logo = new JLabel();
    private final JTextField username = new JTextField("654321",15);
    private final JPasswordField password = new JPasswordField("654321",15);
    private final JButton logBtn = new JButton("Log In");

    public LogInPanel() {
        setPreferredSize(new Dimension(650,400));
        setLayout(new GridLayout(2,1));

        setLogoPanel();
        setInputPanel();

        add(logoPanel);
        add(inputPanel);
    }

    public void setLogoPanel() {
        logoPanel.setBackground(ConstantString.COLOR_BLUE);
        logoPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        ImageIcon icon = new ImageIcon("src/main/resources/images/oasys.png");
        logo.setIcon(icon);

        constraints.anchor = GridBagConstraints.CENTER;
        logoPanel.add(logo,constraints);
    }

    public void setInputPanel() {
        inputPanel.setBackground(ConstantString.COLOR_BLUE);
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
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
    }
}
