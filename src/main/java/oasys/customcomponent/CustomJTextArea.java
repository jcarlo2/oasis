package oasys.customcomponent;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class CustomJTextArea extends JTextArea {

    public CustomJTextArea() {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public CustomJTextArea(String str) {
        setText(str);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }
}
