package oasys;

import com.formdev.flatlaf.FlatIntelliJLaf;
import oasys.view.teacher.TeacherFrame;

import javax.swing.*;
import java.awt.*;

public class OASYSApplication {

    public static void main(String[]args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    new TeacherFrame();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
