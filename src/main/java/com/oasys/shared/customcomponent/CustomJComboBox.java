package com.oasys.shared.customcomponent;

import javax.swing.*;

public class CustomJComboBox extends JComboBox<String> {
    public CustomJComboBox() {
        centerText();
        addItem("Appointment");
        addItem("Inquiry");
    }

    private void centerText() {
        ((JTextField) getEditor().getEditorComponent()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }
}
