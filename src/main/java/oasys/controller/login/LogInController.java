package oasys.controller.login;

import oasys.controller.database.StudentDatabase;
import oasys.controller.database.TeacherDatabase;
import oasys.controller.database.UserDatabase;
import oasys.model.MainModel;
import oasys.model.Student;
import oasys.model.Teacher;
import oasys.util.Dialog;
import oasys.view.BuildGUI;
import oasys.view.login.LogInPanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogInController extends AbstractAction{
    private final LogInPanel logInPanel;
    private final UserDatabase userDatabase = new UserDatabase();
    private final StudentDatabase studentDatabase = new StudentDatabase();
    private final TeacherDatabase teacherDatabase = new TeacherDatabase();
    private final BuildGUI buildGUI;
    private final MainModel mainModel;

    public LogInController(@NotNull BuildGUI buildGUI, MainModel mainModel) {
        logInPanel = buildGUI.getLogInFrame().getLogInPanel();
        this.buildGUI = buildGUI;
        this.mainModel = mainModel;

        setLogInBtn();
        keyListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logInEvent();
    }

    private void setLogInBtn() {
        logInPanel.getLogBtn().addActionListener(e -> {
            logInEvent();
        });
    }

    private void keyListener() {
        int input = JComponent.WHEN_IN_FOCUSED_WINDOW;
        logInPanel.getLogBtn().getInputMap(input).put(KeyStroke.getKeyStroke("ENTER"), "Enter");
        logInPanel.getLogBtn().getActionMap().put("Enter", this);
    }

    private void logInEvent() {
        if(checkUsernameAndPassword())  createFrame(userDatabase.getRole(logInPanel.getUsername().getText()));
        else Dialog.LOG_IN_FAILED();
    }

    private void setStudentInformation() {
        Student student = studentDatabase.getStudentInformation(logInPanel.getUsername().getText());
        mainModel.getStudent().setId(student.getId());
        mainModel.getStudent().setName(student.getName());
        mainModel.getStudent().setEmail(student.getEmail());
        mainModel.getStudent().setCampus(student.getCampus());
        mainModel.getStudent().setAcademicLevel(student.getAcademicLevel());
        mainModel.getStudent().setSection(student.getSection());
        mainModel.getStudent().setProgram(student.getProgram());
        mainModel.getStudent().setYearLevel(student.getYearLevel());
        mainModel.getStudent().setAdviser(student.getAdviser());
    }

    private void setTeacherInformation() {
        Teacher teacher = teacherDatabase.getTeacherInformation(logInPanel.getUsername().getText());
        mainModel.getTeacher().setId(teacher.getId());
        mainModel.getTeacher().setName(teacher.getName());
        mainModel.getTeacher().setEmail(teacher.getEmail());
        mainModel.getTeacher().setCampus(teacher.getCampus());
        mainModel.getTeacher().setDepartment(teacher.getDepartment());
        mainModel.getTeacher().setConsultationHours(teacher.getConsultationHours());
        mainModel.getTeacher().setYear(teacher.getYear());
        mainModel.getTeacher().setAdvisoryClass(teacher.getAdvisoryClass());
    }

    private boolean checkUsernameAndPassword() {
        String id = logInPanel.getUsername().getText();
        String password = String.valueOf(logInPanel.getPassword().getPassword());
        return userDatabase.isIdAndPasswordExist(id,password);
    }

    private void createFrame(@NotNull String role) {
        if(role.equals("student")) {
            buildGUI.getStudentFrame().setVisible(true);
            setStudentInformation();
        }
        if(role.equals("teacher")) {
            buildGUI.getTeacherFrame().setVisible(true);
            setTeacherInformation();
        }
        if(role.equals("admin")) buildGUI.getAdminFrame().setVisible(true);
        buildGUI.getLogInFrame().setVisible(false);
    }
}
