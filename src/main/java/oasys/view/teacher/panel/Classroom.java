package oasys.view.teacher.panel;

import javax.swing.*;
import java.awt.*;

public class Classroom extends JPanel {
    String[] students = {
            "Finana Ryugu",
            "Elira Pendora",
            "Selen Tatsuki",
            "Petra Gurin",
            "Rosemi Lockheart",
            "Nina Kosaka",
            "Millie Parfait",
            "Enna Alouette",
            "Reimu Endou"
    };
    private final JList<String> student = new JList<>(students);
    private final JScrollPane scroll = new JScrollPane(student);

    public Classroom() {
        setLayout(new GridLayout(1,1));
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        student.setCellRenderer(renderer);
        add(scroll);
    }
 }

