package oasys;

import com.formdev.flatlaf.FlatIntelliJLaf;
import oasys.controller.MainController;
import oasys.view.BuildGUI;

import javax.swing.*;
import java.awt.*;

public class OASYSApplication {

    public static void main(String[]args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                new MainController(new BuildGUI());
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
