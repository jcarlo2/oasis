package oasys.view.student.panel.teacher;

import lombok.Getter;
import oasys.customcomponent.CustomJComboBox;
import oasys.customcomponent.CustomJTextArea;
import oasys.customcomponent.CustomJTextField;

import javax.swing.*;
import java.awt.*;

@Getter
public class Concern extends JPanel {
    private final JPanel top = new JPanel();
    private final JPanel bottom = new JPanel();
    private final JPanel wrapper2 = new JPanel();
    private final JPanel wrapper3 = new JPanel();
    private final JPanel wrapper4 = new JPanel();
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
        back.setBackground(Color.RED);
        submit.setBackground(Color.GREEN);

        setTop();
        setBottom();

        add(top,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
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
