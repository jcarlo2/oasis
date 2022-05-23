package com.oasys.view;

import com.oasys.view.student.StudentFrame;
import com.oasys.view.teacher.TeacherFrame;
import lombok.Getter;
import com.oasys.view.admin.AdminFrame;
import com.oasys.view.login.LogInFrame;

@Getter
public class BuildGUI {
    private final AdminFrame adminFrame = new AdminFrame();
    private final LogInFrame logInFrame = new LogInFrame();
    private final StudentFrame studentFrame = new StudentFrame();
    private final TeacherFrame teacherFrame= new TeacherFrame();
}
