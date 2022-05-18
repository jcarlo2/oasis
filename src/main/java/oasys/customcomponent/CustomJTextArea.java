package oasys.customcomponent;

import javax.swing.*;
import java.awt.*;

public class CustomJTextArea extends JTextArea{
    public CustomJTextArea() {
        setWrapStyleWord(true);
        setLineWrap(true);
        setFont(new Font("Monaco",Font.PLAIN,15));
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
    }
}
