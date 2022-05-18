package oasys.customcomponent;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class CustomJButton extends JButton {
    public CustomJButton(String path, int w, int h) {
        setIcon(getIconImage(path, w, h));
    }

    private @NotNull ImageIcon getIconImage(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
