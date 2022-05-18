package oasys.controller.user.teacher;

import oasys.controller.database.TeacherDatabase;
import oasys.customcomponent.TeacherJTable;
import oasys.model.Teacher;
import oasys.view.BuildGUI;
import oasys.view.teacher.TeacherPanel;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TeacherController {
    private final TeacherDatabase database = new TeacherDatabase();
    private final Teacher teacher;
    private final TeacherPanel teacherPanel;
    private final TeacherJTable table;

    public TeacherController(@NotNull BuildGUI buildGUI, @NotNull Teacher teacher) {
        this.teacher = teacher;
        teacherPanel = buildGUI.getTeacherFrame().getTeacherPanel();
        table = teacherPanel.getAccount().getTable();
        updateData();
        setLogOut(buildGUI);
    }

    private void updateData() {
        Runnable runnable = () -> {
            if(teacher.getId() != null) {
                table.addTeacherInformation(database.getTeacherInformation(teacher.getId()));
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    private void setLogOut(BuildGUI buildGUI) {
        teacherPanel.getAccount().getLogout().addActionListener(e -> {
            buildGUI.getLogInFrame().getLogInPanel().getUsername().setText("Username");
            buildGUI.getLogInFrame().getLogInPanel().getPassword().setText("password");
            buildGUI.getTeacherFrame().setVisible(false);
            buildGUI.getLogInFrame().setVisible(true);
        });
    }
}
