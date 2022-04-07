package oasys.student.panel;

import javax.swing.*;
import java.awt.*;

public class Account extends JPanel {
    private final JPanel picturePanel = new JPanel();
    private final JPanel information = new JPanel();
    private final JLabel picture = new JLabel();


    public Account() {
        setLayout(new GridLayout(2,1));
        setPicturePanel();
        add(picturePanel);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/haha.png");
        picture.setIcon(icon);

        picturePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.CENTER;
        picturePanel.add(picture);
    }
}
