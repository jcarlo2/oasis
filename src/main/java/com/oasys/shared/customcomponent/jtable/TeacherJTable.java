package com.oasys.shared.customcomponent.jtable;

import com.oasys.model.Teacher;
import com.oasys.shared.util.ConstantString;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TeacherJTable extends JTable {
    private final DefaultTableModel model = new DefaultTableModel(0,2);

    public TeacherJTable() {
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

    public void addTeacherInformation(@NotNull Teacher teacher) {
        model.setRowCount(0);
        model.addRow(new String[]{"Name",teacher.getName()});
        model.addRow(new String[]{"Email",teacher.getEmail()});
        model.addRow(new String[]{"Campus",teacher.getCampus()});
        model.addRow(new String[]{"Department",teacher.getDepartment()});
        model.addRow(new String[]{"Advisory Class",setSections(teacher.getAdvisoryClass())});
        model.addRow(new String[]{"Consultation Hours",teacher.getConsultationHours()});
        model.addRow(new String[]{"Teacher Id",teacher.getId()});
    }

    private @NotNull String setSections(@NotNull ArrayList<String> sectionList) {
        StringBuilder sections = new StringBuilder();
            for(String str : sectionList) {
                sections.append(str).append(", ");
            }
        return sections.substring(0,sections.length() - 2);
    }
}
