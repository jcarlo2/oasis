package oasys.view.student.panel.teacher;

import lombok.Getter;
import oasys.customcomponent.*;

import javax.swing.*;
import java.awt.*;

import static oasys.util.ConstantString.COLOR_BLUE;

@Getter
public class Concern extends CustomJPanel {
    private final JPanelBlueBackground top = new JPanelBlueBackground();
    private final JPanelBlueBackground bottom = new JPanelBlueBackground();
    private final JPanelBlueBackground wrapper2 = new JPanelBlueBackground();
    private final JPanelBlueBackground wrapper3 = new JPanelBlueBackground();
    private final JPanelBlueBackground wrapper4 = new JPanelBlueBackground();
    private final JButton back = new JButton("Back");
    private final JButton submit = new JButton("Submit");
    private final CustomJTextArea textArea = new CustomJTextArea();
    private final CustomJTextField teacherField = new CustomJTextField("Teacher",false);
    private final CustomJTextField studentField = new CustomJTextField("Student",false);
    private final CustomJTextField subjectField = new CustomJTextField("Subject",true);
    private final CustomJTextField reportId = new CustomJTextField("ReportId",false);
    private final CustomJComboBox comboBox = new CustomJComboBox();

    public Concern() {
        setLayout(new BorderLayout());
        setComponentBackground();
        setTop();
        setBottom();
        add(top,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
    }

    private void setComponentBackground() {
        reportId.setBackground(COLOR_BLUE);
        studentField.setBackground(COLOR_BLUE);
        teacherField.setBackground(COLOR_BLUE);
        subjectField.setBackground(COLOR_BLUE);
        textArea.setBackground(COLOR_BLUE);
        comboBox.setBackground(COLOR_BLUE);
        back.setBackground(Color.RED);
        submit.setBackground(Color.GREEN);
    }

    private void setTop() {
        wrapper3.setLayout(new GridLayout(1,2));
        wrapper3.add(studentField);
        wrapper3.add(teacherField);

        wrapper4.setLayout(new BorderLayout());
        wrapper4.add(subjectField,BorderLayout.CENTER);
        wrapper4.add(comboBox,BorderLayout.EAST);

        top.setLayout(new GridLayout(2,1));
        top.add(wrapper3);
        top.add(wrapper4);
    }

    private void setBottom() {
        wrapper2.setLayout(new GridBagLayout());
        wrapper2.add(reportId);

        bottom.setLayout(new BorderLayout());
        bottom.add(back,BorderLayout.WEST);
        bottom.add(submit,BorderLayout.EAST);
        bottom.add(wrapper2,BorderLayout.CENTER);
    }
}
