package com.oasys.shared.customcomponent.jpanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.oasys.shared.util.ConstantString.COLOR_BLUE;

public class CustomJPanel extends JPanel {
    public CustomJPanel() {
        setBorder(new EmptyBorder(10,10,10,10));
        setLayout(new BorderLayout(0,10));
        setBackground(COLOR_BLUE);
    }
}
