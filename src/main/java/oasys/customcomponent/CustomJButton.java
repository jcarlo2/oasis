package oasys.customcomponent;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomJButton extends JButton {
    private final ImageIcon firstImage;
    private final ImageIcon secondImage;
    private final int W;
    private final int H;

    public CustomJButton(String firstPath, String secondPath, int W, int H) {
        this.W = W;
        this.H = H;
        firstImage = new ImageIcon(firstPath);
        secondImage = new ImageIcon(secondPath);
        setIcon(getIconImage(firstImage, W, H));
        setBorder(BorderFactory.createEmptyBorder());
        changeIconIfMouseHover();
    }

    private @NotNull ImageIcon getIconImage(@NotNull ImageIcon icon, int w, int h) {
        return new ImageIcon(icon.getImage().getScaledInstance(w,h,Image.SCALE_SMOOTH));
    }

    private void changeIconIfMouseHover() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setIcon(getIconImage(secondImage, W, H));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setIcon(getIconImage(firstImage, W, H));
            }
        });
    }
}
