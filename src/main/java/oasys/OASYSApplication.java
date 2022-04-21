package oasys;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import oasys.view.login.LogInFrame;
import oasys.view.teacher.TeacherFrame;

import javax.swing.*;
import java.awt.*;

public class OASYSApplication {

    public static void main(String[]args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
              new TeacherFrame();
//                new LogInFrame();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
