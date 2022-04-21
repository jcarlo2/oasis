package oasys.customcomponent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CustomJTextField extends JTextField {
    public CustomJTextField(String title) {
        setColumns(15);
        setTitledBorder(title);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setTitledBorder(String title) {
        setBorder(BorderFactory.createTitledBorder
                (new LineBorder(Color.BLACK),title,
                        TitledBorder.CENTER,TitledBorder.CENTER,
                        new Font("SansSerif",Font.BOLD,15)));
    }
}
