package oasys.customcomponent;

import javax.swing.text.*;


public class MyEditorKit extends StyledEditorKit {

    public ViewFactory getViewFactory() {
        return new StyledViewFactory();
    }

    public static class StyledViewFactory implements ViewFactory {
        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                switch (kind) {
                    case AbstractDocument.ContentElementName:
                        return new LabelView(elem);
                    case AbstractDocument.ParagraphElementName:
                        return new ParagraphView(elem);
                    case AbstractDocument.SectionElementName:
                        return new CenteredBoxView(elem, View.Y_AXIS);
                    case StyleConstants.ComponentElementName:
                        return new ComponentView(elem);
                    case StyleConstants.IconElementName:
                        return new IconView(elem);
                }
            }
            return new LabelView(elem);
        }

    }
}

class CenteredBoxView extends BoxView {
    public CenteredBoxView(Element elem, int axis) {
        super(elem,axis);
    }
    protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {

        super.layoutMajorAxis(targetSpan,axis,offsets,spans);
        int textBlockHeight = 0;
        int offset;

        for (int span : spans)  textBlockHeight = span;

        offset = (targetSpan - textBlockHeight) / 2;
        for (int i = 0; i < offsets.length; i++) offsets[i] += offset;

    }
}

