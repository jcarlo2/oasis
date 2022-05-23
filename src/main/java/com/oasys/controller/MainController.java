package com.oasys.controller;

import com.oasys.controller.login.LogInController;
import com.oasys.controller.user.student.StudentController;
import com.oasys.controller.user.teacher.TeacherController;
import com.oasys.model.MainModel;
import com.oasys.view.BuildGUI;
import org.jetbrains.annotations.NotNull;

public class MainController {
    public MainController(@NotNull BuildGUI buildGUI, MainModel mainModel) {
        new LogInController(buildGUI,mainModel);
        new StudentController(buildGUI,mainModel.getStudent());
        new TeacherController(buildGUI,mainModel.getTeacher());
    }
}
