package oasys.view.teacher.panel.classroom;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class ClassroomCard extends JPanel {
    private final CardLayout card = new CardLayout();
    private final Classroom classroom = new Classroom();
    private final Section section = new Section();

    public ClassroomCard() {
        setLayout(card);
        add("class", classroom);
        add("section", section);
        card.show(this,"class");
    }
}
