package oasys.view;

import lombok.Getter;
import oasys.view.admin.AdminFrame;
import oasys.view.login.LogInFrame;
import oasys.view.student.StudentFrame;
import oasys.view.teacher.TeacherFrame;

@Getter
public class BuildGUI {
    private final AdminFrame adminFrame = new AdminFrame();
    private final LogInFrame logInFrame = new LogInFrame();
    private final StudentFrame studentFrame = new StudentFrame();
    private final TeacherFrame teacherFrame= new TeacherFrame();
}
