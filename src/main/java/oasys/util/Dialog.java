package oasys.util;

import javax.swing.*;

public interface Dialog {
    static void LOG_IN_FAILED() {
        JOptionPane.showMessageDialog(new JFrame(), "log in failed!!");
    }
}
