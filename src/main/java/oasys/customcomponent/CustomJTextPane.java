package oasys.customcomponent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CustomJTextPane extends JTextPane {
    public CustomJTextPane(boolean isCenterText) {
        setEditable(false);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        if(isCenterText) centerText();
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
