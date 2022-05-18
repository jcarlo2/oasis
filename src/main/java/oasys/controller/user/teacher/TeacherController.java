package oasys.controller.user.teacher;

import oasys.controller.database.TeacherDatabase;
import oasys.customcomponent.jtable.TeacherJTable;
import oasys.model.Teacher;
import oasys.view.BuildGUI;
import oasys.view.teacher.TeacherPanel;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TeacherController {
    private final TeacherDatabase database = new TeacherDatabase();
    private final TeacherPanel teacherPanel;
    private final TeacherJTable table;
    private Teacher teacher;


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
                addTeacherInformationToTable();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    private void addTeacherInformationToTable() {
        if(table.getRowCount() == 0) table.addTeacherInformation(teacher);
        if(!isSameData(teacher)) {
            teacher = database.getTeacherInformation(teacher.getId());
            table.addTeacherInformation(teacher);
        }
    }

    private boolean isSameData(@NotNull Teacher teacher) {
        return teacher.equals(database.getTeacherInformation(teacher.getId()));
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
