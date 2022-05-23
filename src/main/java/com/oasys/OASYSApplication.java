package com.oasys;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.oasys.model.MainModel;
import com.oasys.shared.util.TableCreatorImpl;
import com.oasys.controller.MainController;
import com.oasys.view.BuildGUI;

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
