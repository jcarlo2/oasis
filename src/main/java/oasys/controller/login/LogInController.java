package oasys.controller.login;

import oasys.controller.database.UserDatabase;
import oasys.util.Dialog;
import oasys.view.BuildGUI;
import oasys.view.login.LogInPanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LogInController {
    private final UserDatabase userDatabase = new UserDatabase();
    private final BuildGUI buildGUI;
    private final LogInPanel logInPanel;
    private final JButton logInBtn;

    public LogInController(@NotNull BuildGUI buildGUI) {
        this.buildGUI = buildGUI;
        logInPanel = buildGUI.getLogInFrame().getLogInPanel();
        logInBtn = logInPanel.getLogBtn();

        setLogInBtn();
    }


    private void setLogInBtn() {
        logInBtn.addActionListener(e -> {
            if(checkUsernameAndPassword())  createFrame(userDatabase.getRole(logInPanel.getUsername().getText()));
            else Dialog.LOG_IN_FAILED();
        });
    }

    private boolean checkUsernameAndPassword() {
        String id = logInPanel.getUsername().getText();
        String password = String.valueOf(logInPanel.getPassword().getPassword());
        return userDatabase.isIdAndPasswordExist(id,password);
    }

    private void createFrame(@NotNull String role) {
        if(role.equals("student")) buildGUI.getStudentFrame().setVisible(true);
        if(role.equals("teacher")) buildGUI.getTeacherFrame().setVisible(true);
        if(role.equals("admin")) buildGUI.getAdminFrame().setVisible(true);

    }
}
