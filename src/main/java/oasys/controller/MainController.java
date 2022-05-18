package oasys.controller;

import oasys.controller.login.LogInController;
import oasys.controller.user.student.StudentController;
import oasys.controller.user.teacher.TeacherController;
import oasys.model.MainModel;
import oasys.view.BuildGUI;
import org.jetbrains.annotations.NotNull;

public class MainController {
    public MainController(@NotNull BuildGUI buildGUI, MainModel mainModel) {
        new LogInController(buildGUI,mainModel);
        new StudentController(buildGUI,mainModel.getStudent());
        new TeacherController(buildGUI,mainModel.getTeacher());
    }
}
