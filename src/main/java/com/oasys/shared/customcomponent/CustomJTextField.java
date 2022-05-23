package com.oasys.shared.customcomponent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CustomJTextField extends JTextField {
    public CustomJTextField(String title, boolean isEditable) {
        setColumns(15);
        setEditable(isEditable);
        setTitledBorder(title);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public CustomJTextField(String title, boolean isEditable, Color color) {
        setColumns(15);
        setBackground(color);
        setEditable(isEditable);
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
