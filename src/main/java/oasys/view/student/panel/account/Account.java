package oasys.view.student.panel.account;

import lombok.Getter;
import oasys.customcomponent.CustomJButton;
import oasys.customcomponent.JPanelBlueBackground;
import oasys.customcomponent.jtable.StudentJTable;

import javax.swing.*;
import java.awt.*;

import static oasys.util.ConstantString.*;

@Getter
public class Account extends JPanel {
    private final JPanelBlueBackground wrapper1 = new JPanelBlueBackground();
    private final JPanelBlueBackground wrapper2 = new JPanelBlueBackground();
    private final JPanelBlueBackground wrapper3 = new JPanelBlueBackground();
    private final JPanelBlueBackground informationPanel = new JPanelBlueBackground();
    private final JPanelBlueBackground bottomPanel = new JPanelBlueBackground();
    private final JPanelBlueBackground picturePanel = new JPanelBlueBackground();
    private final JLabel picture = new JLabel();
    private final StudentJTable table = new StudentJTable();
    private final CustomJButton mailBox = new CustomJButton(MAIL_RED,MAIL_GREEN,100,70);
    private final CustomJButton logOut = new CustomJButton(LOGOUT_BLUE,LOGOUT_RED,100,50);

    public Account() {
        setLayout(new GridLayout(2,1));
        setPicturePanel();
        setInformationPanel();
        setWrapper();

        add(wrapper1);
        add(informationPanel);
    }

    private void setInformationPanel() {
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(logOut,BorderLayout.EAST);

        informationPanel.setLayout(new BorderLayout());
        informationPanel.add(table,BorderLayout.CENTER);
        informationPanel.add(bottomPanel,BorderLayout.SOUTH);
    }

    private void setWrapper() {
        wrapper1.setLayout(new BorderLayout());
        wrapper1.add(picturePanel,BorderLayout.CENTER);
        wrapper1.add(wrapper2,BorderLayout.NORTH);

        wrapper2.setLayout(new BorderLayout());
        wrapper2.add(wrapper3,BorderLayout.WEST);
        wrapper3.add(mailBox);
    }

    private void setPicturePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/images/haha.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        picture.setIcon(icon);
        picturePanel.setLayout(new GridBagLayout());
        picturePanel.add(picture);
    }
}
