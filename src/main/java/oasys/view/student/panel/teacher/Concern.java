package oasys.view.student.panel.teacher;

import lombok.Getter;
import oasys.customcomponent.CustomJTextField;

import javax.swing.*;
import java.awt.*;

@Getter
public class Concern extends JPanel {
    private final JPanel wrapper = new JPanel();
    private final JPanel wrapper1 = new JPanel();
    private final JButton back = new JButton("Back");
    private final JButton submit = new JButton("Submit");
    private final JTextArea textArea = new JTextArea("CONCERN NI ABRIOL AY BAKIT ARAW-ARAW SYANG GWAPO :(");
    private final CustomJTextField teacherField = new CustomJTextField("Teacher");
    private final CustomJTextField studentField = new CustomJTextField("Student");
    private final CustomJTextField subjectField = new CustomJTextField("Subject");

    public Concern() {
        setLayout(new BorderLayout());
        back.setBackground(Color.RED);
        submit.setBackground(Color.GREEN);

        setTextArea();
        setWrapper();
        setWrapper1();

        add(wrapper,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);
        add(wrapper1,BorderLayout.SOUTH);
    }

    private void setWrapper() {
        wrapper.setLayout(new GridLayout(3,1));
        wrapper.add(teacherField);
        wrapper.add(studentField);
        wrapper.add(subjectField);
    }

    private void setWrapper1() {
        wrapper1.setLayout(new BorderLayout());
        wrapper1.add(back,BorderLayout.WEST);
        wrapper1.add(submit,BorderLayout.EAST);
    }

    private void setTextArea() {
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
    }
}
