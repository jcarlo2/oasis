package oasys.customcomponent;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomJTable extends JTable {
    private final DefaultTableModel model = new DefaultTableModel(0,3);

    public CustomJTable(String[] columnName) {
        setModel(model);
        setColumnName(columnName);
    }

    private void setColumnName(@NotNull String columnName[]) {
        for(int i=0;i<columnName.length;i++) getColumnModel().getColumn(i).setHeaderValue(columnName[i]);
    }
}
