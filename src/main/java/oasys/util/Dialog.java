package oasys.util;

import javax.swing.*;

public interface Dialog {
    static void LOG_IN_FAILED() {
        JOptionPane.showMessageDialog(new JFrame(), "log in failed!!");
    }

    static void SUBMIT_SUCCESSFUL() {
        JOptionPane.showMessageDialog(new JFrame(), "Submitted");
    }

    static void GENERATE_NEW_ID() {
        JOptionPane.showMessageDialog(new JFrame(), "generate new id");
    }

    static void EMPTY_FIELD() {
        JOptionPane.showMessageDialog(new JFrame(), "check empty field");
    }
}
