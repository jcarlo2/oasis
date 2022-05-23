package com.oasys.shared.customcomponent.jtable;

import com.oasys.dto.ConcernReport;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

@Getter
public class MailboxJTable extends JTable {
    private final DefaultTableModel model;

    public MailboxJTable(String @NotNull [] columnName) {
        model = new DefaultTableModel(0,columnName.length);
        setModel(model);
        setColumn(columnName);
        setGridColor(Color.BLACK);
        setUpTable();
    }

    private void setColumn(String @NotNull [] columnName) {
        for(int i=0;i<columnName.length;i++) getColumnModel().getColumn(i).setHeaderValue(columnName[i]);
        getColumnModel().getColumn(0).setMinWidth(30);
        getColumnModel().getColumn(0).setMaxWidth(30);
    }

    public void addRowMailBox(@NotNull ArrayList<ConcernReport> reportList) {
        model.setRowCount(0);
        for(ConcernReport report : reportList) {
            model.addRow(new String[] {
            String.valueOf(model.getRowCount() + 1),
            report.getStatus(),
            report.getSubject(),
            report.getType(),
            report.getReportId(),
            report.getAdviser()});
        }
    }

    private void setUpTable() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class,renderer); // CENTER TEXT
        setShowVerticalLines(false);
        setShowHorizontalLines(true);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(false);
        setDefaultEditor(Object.class,null); // DISABLE EDIT setEditable(false)
    }
}
