package com.oasys.shared.customcomponent.jtable;

import lombok.Getter;
import com.oasys.model.Student;
import com.oasys.shared.util.ConstantString;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@Getter
public class StudentJTable extends JTable {
    private final DefaultTableModel model = new DefaultTableModel(0,2);

    public StudentJTable() {
        setModel(model);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class,renderer); // CENTER TEXT
        setShowVerticalLines(true);
        setShowHorizontalLines(true);

        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(false);
        setDefaultEditor(Object.class,null); // DISABLE EDIT setEditable(false)
        setBackground(ConstantString.COLOR_BLUE);
    }

    public void addStudentInformation(@NotNull Student student) {
        model.setRowCount(0);
        model.addRow(new String[]{"Name",student.getName()});
        model.addRow(new String[]{"Email",student.getEmail()});
        model.addRow(new String[]{"Campus",student.getCampus()});
        model.addRow(new String[]{"Academic Level",student.getAcademicLevel()});
        model.addRow(new String[]{"Section",student.getSection()});
        model.addRow(new String[]{"Program",student.getProgram()});
        model.addRow(new String[]{"Year Level",student.getYearLevel()});
        model.addRow(new String[]{"Student ID",student.getId()});
    }
}
