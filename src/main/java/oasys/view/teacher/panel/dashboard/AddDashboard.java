package oasys.view.teacher.panel.dashboard;

import lombok.Getter;
import oasys.customcomponent.CustomJPanel;
import oasys.customcomponent.CustomJTextPane;

import javax.swing.*;
import java.awt.*;

@Getter
public class AddDashboard extends CustomJPanel {
    private final JPanel wrapper = new JPanel();
    private final JButton back = new JButton("Back");
    private final JButton submit = new JButton("Submit");
    private final JButton clear = new JButton("Clear");
    private final CustomJTextPane textArea = new CustomJTextPane( false,true);
    private final CustomJTextPane title = new CustomJTextPane( true,true);

    public AddDashboard() {
        setWrapper();

        add(title,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);
        add(wrapper,BorderLayout.SOUTH);
    }

    private void setWrapper() {
        wrapper.setLayout(new GridLayout(1,3));
        wrapper.add(back);
        wrapper.add(submit);
        wrapper.add(clear);
    }
}

