package oasys.customcomponent;

import lombok.Getter;
import oasys.model.dto.ConcernReport;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

@Getter
public class CustomJTable extends JTable {
    private final DefaultTableModel model;

    public CustomJTable(String @NotNull [] columnName) {
        model = new DefaultTableModel(0,columnName.length);
        setModel(model);
        setColumnName(columnName);
        setUpTable();
    }

    public CustomJTable(String @NotNull [] columnName,boolean isMailbox) {
        model = new DefaultTableModel(0,columnName.length);
        setModel(model);
        setColumnName(columnName);
        if(isMailbox) {
            getColumnModel().getColumn(0).setMinWidth(30);
            getColumnModel().getColumn(0).setMaxWidth(30);
        }
        setGridColor(Color.BLACK);
        setUpTable();
    }

    private void setColumnName( String @NotNull [] columnName) {
        for(int i=0;i<columnName.length;i++) getColumnModel().getColumn(i).setHeaderValue(columnName[i]);
    }

    public void addRowMailBox(@NotNull ArrayList<ConcernReport> reportList) {
        model.setRowCount(0);
        for(ConcernReport report : reportList) {
            model.addRow(new String[] {String.valueOf(model.getRowCount() + 1),report.getStudentName(),
                    report.getAdviser(),report.getSubject(),
                    report.getReportId(),report.getStatus()});
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
