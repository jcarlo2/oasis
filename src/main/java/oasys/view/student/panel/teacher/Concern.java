package oasys.view.student.panel.teacher;

import lombok.Getter;
import oasys.customcomponent.CustomJTextField;

import javax.swing.*;
import java.awt.*;

@Getter
public class Concern extends JPanel {
    private final JPanel wrapper = new JPanel();
    private final JPanel wrapper1 = new JPanel();
    private final JPanel wrapper2 = new JPanel();
    private final JButton back = new JButton("Back");
    private final JButton submit = new JButton("Submit");
    private final JTextArea textArea = new JTextArea("CONCERN NI ABRIOL AY BAKIT ARAW ARAW SYANG GWAPO :(@@@@@@@@@@@@@@@@@@@@@@@@@");
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

        add(wrapper,BorderLayout.CENTER);
        add(wrapper2,BorderLayout.SOUTH);
    }

    private void setWrapper() {
        wrapper.setLayout(new BorderLayout());

        wrapper1.setLayout(new GridLayout(3,1));
        wrapper1.add(teacherField);
        wrapper1.add(studentField);
        wrapper1.add(subjectField);

        wrapper.add(wrapper1,BorderLayout.NORTH);
        wrapper.add(textArea,BorderLayout.CENTER);
    }

    private void setTextArea() {
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
    }

    private void setWrapper1() {
        wrapper2.setLayout(new BorderLayout());
        wrapper2.add(back,BorderLayout.WEST);
        wrapper2.add(submit,BorderLayout.EAST);
    }
}
