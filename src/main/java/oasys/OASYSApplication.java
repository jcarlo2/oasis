package oasys;

import com.formdev.flatlaf.FlatIntelliJLaf;
import oasys.controller.MainController;
import oasys.model.MainModel;
import oasys.util.TableCreatorImpl;
import oasys.view.BuildGUI;

import javax.swing.*;
import java.awt.*;

public class OASYSApplication {

    public static void main(String[]args){

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                new TableCreatorImpl();
                new MainController(new BuildGUI(),new MainModel());
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
