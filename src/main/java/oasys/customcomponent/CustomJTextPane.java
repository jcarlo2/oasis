package oasys.customcomponent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

import static oasys.util.ConstantString.COLOR_BLUE;

public class CustomJTextPane extends JTextPane {

    public CustomJTextPane(boolean isCenterText, boolean isEditable) {
        setEditable(isEditable);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        if(isCenterText) centerText();
    }

    public CustomJTextPane(boolean isCenterText, boolean isEditable, String str) {
        setEditable(isEditable);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        if(isCenterText) centerText();
        setBackground(COLOR_BLUE);
        setText(str);
    }

    public void changeBorderColor(boolean isChange) {
        if(isChange) setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN,Color.RED));
        else setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    private void centerText() {
        setEditorKit(new MyEditorKit());
        StyledDocument doc = this.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        attr.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
        StyleConstants.setFontSize(attr, 30);
        StyleConstants.setAlignment(attr, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), attr, false);
    }
}
