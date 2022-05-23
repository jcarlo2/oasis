package com.oasys.shared.customcomponent;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomJList extends JList<String> {
    private final DefaultListModel<String> model = new DefaultListModel<>();
    public CustomJList() {
        setModel(model);
        setUpJList();
        setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        setFont(new Font("Monaco",Font.PLAIN,20));
    }

    public void addAllToList(@NotNull ArrayList<String> strList) {
        model.removeAllElements();
        for(String str : strList) {
            model.addElement(str);
        }
    }

    public boolean checkIfSameData(ArrayList<String> strList) {
        if(getVisibleRowCount() == 0 || strList.size() == 0) return false;
        ArrayList<String> oldStrList = new ArrayList<>();
        for(int i=0;i<model.getSize();i++) oldStrList.add(getModel().getElementAt(i));
        return compareList(strList,oldStrList);
    }

    private boolean compareList(@NotNull ArrayList<String> strList, @NotNull ArrayList<String> oldStrList) {
        if(strList.size() != oldStrList.size()) return false;
        for (String s : strList) if (!oldStrList.contains(s)) return false;
        return true;
    }

    private void setUpJList() {
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        setCellRenderer(renderer);
    }
}
