package oasys;

import com.formdev.flatlaf.FlatIntelliJLaf;
import oasys.view.admin.AdminFrame;
import oasys.view.student.StudentFrame;

import javax.swing.*;
import java.awt.*;

public class OASYSApplication {

    public static void main(String[]args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    new AdminFrame();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
