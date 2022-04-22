package oasys.customcomponent;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class CustomJTextArea extends JTextArea {
    public CustomJTextArea(String str) {
        setText(str);
        setEnabled(false);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }
}
