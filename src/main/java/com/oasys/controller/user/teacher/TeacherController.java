package com.oasys.controller.user.teacher;

import com.oasys.controller.database.TeacherDatabase;
import com.oasys.shared.customcomponent.jtable.TeacherJTable;
import com.oasys.view.teacher.panel.dashboard.DashboardCard;
import com.oasys.controller.database.AnnouncementDatabase;
import com.oasys.controller.database.StudentDatabase;
import com.oasys.shared.customcomponent.CustomJList;
import com.oasys.shared.customcomponent.CustomJTextPane;
import com.oasys.model.Teacher;
import com.oasys.dto.Announcement;
import com.oasys.shared.util.Dialog;
import com.oasys.view.BuildGUI;
import com.oasys.view.teacher.TeacherPanel;
import com.oasys.view.teacher.panel.classroom.ClassroomCard;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TeacherController {
    private final TeacherDatabase teacherDatabase = new TeacherDatabase();
    private final StudentDatabase studentDatabase = new StudentDatabase();
    private final AnnouncementDatabase announcementDatabase = new AnnouncementDatabase();
    private final DashboardCard dashboardCard;
    private final ClassroomCard classroomCard;
    private final TeacherPanel teacherPanel;
    private final TeacherJTable table;
    private final CustomJList customJList;
    private Teacher teacher;
    private int boardNum;
    private int selectedDashboard = -1;

    public TeacherController(@NotNull BuildGUI buildGUI, @NotNull Teacher teacher) {
        this.teacher = teacher;
        teacherPanel = buildGUI.getTeacherFrame().getTeacherPanel();
        customJList = teacherPanel.getClassroomCard().getClassroom().getList();
        dashboardCard = teacherPanel.getDashboardCard();
        classroomCard = teacherPanel.getClassroomCard();
        table = teacherPanel.getAccount().getTable();
        updateData();
        setLogOut(buildGUI);
        prevAnnouncement();
        nextAnnouncement();
        addMouseListenerToDashboard();
        deactivateAnnouncement();
        addPostDashboardListener();
        addAnnouncementBack();
        addDashboardBack();
        addSectionBack();
        createNewPost();
        clear();
        addSectionListListener();
    }

    private void updateData() {
        Runnable runnable = () -> {
            if(teacher.getId() != null) {
                addTeacherInformationToTable();
                setDashboardTitle();
                getSection();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    private void getSection() {
        ArrayList<String> sectionList = teacherDatabase.getSections(teacher.getId(),teacher.getYear());
        if(customJList.checkIfSameData(sectionList)) return;
        customJList.addAllToList(sectionList);
    }

    private void createNewPost() {
        dashboardCard.getAddDashboard().getSubmit().addActionListener(e -> {
            String title = dashboardCard.getAddDashboard().getTitle().getText();
            String detail = dashboardCard.getAddDashboard().getTextArea().getText();
            if(title.equals("") || detail.equals("")) {
                Dialog.EMPTY_FIELD();
                return;
            }
            announcementDatabase.addAnnouncement(new Announcement(teacher.getId(),teacher.getName(),title,detail));
            dashboardCard.getCard().show(dashboardCard,"dashboard");
            Dialog.SUBMIT_SUCCESSFUL();
            clearAddDashboard();
        });
    }

    private void clearAddDashboard() {
        dashboardCard.getAddDashboard().getTitle().setText("");
        dashboardCard.getAddDashboard().getTextArea().setText("");
    }

    private void clear() {
        dashboardCard.getAddDashboard().getClear().addActionListener(e -> clearAddDashboard());
    }

    private void deactivateAnnouncement() {
        dashboardCard.getDashboard().getDelete().addActionListener(e -> {
            if(selectedDashboard == -1) {
                Dialog.SELECT_DASHBOARD();
                return;
            }
            String[] data = getAnnouncementTitleAndDetail(selectedDashboard);
            if(data[0] == null && data[1] == null) {
                Dialog.SELECT_DASHBOARD();
                return;
            }
            announcementDatabase.deactivateAnnouncement(data[0],data[1]);
            selectedDashboard = -1;
        });
    }

    private String @NotNull [] getAnnouncementTitleAndDetail(int num) {
        String[] data = new String[2];
        String[] title = announcementDatabase.getTitle(teacher.getId());
        String[] detail = announcementDatabase.getDetail(teacher.getId());
        data[0] = title[num];
        data[1] = detail[num];
        return data;
    }

    private void nextAnnouncement() {
        dashboardCard.getAnnouncementBoard().getNext().addActionListener(e -> {
            if(boardNum >= 5) {
                setAnnouncementTitleAndDetail(0);
                boardNum = 0;
                return;
            }
            boardNum++;
            setAnnouncementTitleAndDetail(boardNum);
        });
    }

    private void prevAnnouncement() {
        dashboardCard.getAnnouncementBoard().getPrevious().addActionListener(e -> {
            if(boardNum <= 0) {
                setAnnouncementTitleAndDetail(5);
                boardNum = 5;
                return;
            }
            boardNum--;
            setAnnouncementTitleAndDetail(boardNum);
        });
    }

    private void setDashboardTitle() {
        String[] data = announcementDatabase.getTitle(teacher.getId());
        for(int i=0;i<data.length;i++) {
            dashboardCard.getDashboard().getDashList().get(i).setText(data[i]);
        }
    }

    private void setAnnouncementTitleAndDetail(int num) {
        String[] detail = announcementDatabase.getDetail(teacher.getId());
        String[] title = announcementDatabase.getTitle(teacher.getId());
        for(int i=0;i<title.length;i++) {
            if(num == i) dashboardCard.getAnnouncementBoard().getTextArea().setText(detail[i]);
            if(num == i) dashboardCard.getAnnouncementBoard().getTitle().setText(title[i]);
        }
    }

    private void addMouseListenerToDashboard() {
        final int DASHBOARD_QUANTITY = 6;
        for(int i=0;i<DASHBOARD_QUANTITY;i++) {
            setMouseListener(dashboardCard.getDashboard().getDashList(),i);
        }
    }

    private void setMouseListener(@NotNull ArrayList<CustomJTextPane> dashList, int num) {
        dashList.get(num).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(dashboardCard,"announcement");
                    setAnnouncementTitleAndDetail(num);
                    boardNum = num;
                }
               if(e.getClickCount() == 1) {
                   for(int i=0;i<dashList.size();i++) {
                       dashList.get(i).changeBorderColor(num == i);
                       selectedDashboard = num;
                   }
               }
            }
        });
    }

    private void addTeacherInformationToTable() {
        if(table.getRowCount() == 0) table.addTeacherInformation(teacher);
        if(!isSameData(teacher)) {
            teacher = teacherDatabase.getTeacherInformation(teacher.getId());
            table.addTeacherInformation(teacher);
        }
    }

    private void addPostDashboardListener() {
        dashboardCard.getDashboard().getPost().addActionListener(e -> {
            if(announcementDatabase.isMaximumActive(teacher.getId())) {
                Dialog.FULL_DASHBOARD();
                return;
            }
            dashboardCard.getCard().show(dashboardCard,"add");
        });
    }

    private void addDashboardBack() {
        dashboardCard.getAddDashboard().getBack().addActionListener(e -> dashboardCard.getCard().show(dashboardCard,"dashboard"));
    }

    private void addAnnouncementBack() {
        dashboardCard.getAnnouncementBoard().getBack().addActionListener(e -> dashboardCard.getCard().show(dashboardCard,"dashboard"));
    }

    private void addSectionBack() {
        classroomCard.getSection().getBack().addActionListener(e -> classroomCard.getCard().show(classroomCard,"class"));
    }

    private boolean isSameData(@NotNull Teacher teacher) {
        return teacher.equals(teacherDatabase.getTeacherInformation(teacher.getId()));
    }

    private void addSectionListListener() {
        classroomCard.getClassroom().getList().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    populateStudentList();
                    classroomCard.getCard().show(classroomCard,"section");
                }
            }
        });
    }

    private void populateStudentList() {
        String section = classroomCard.getClassroom().getList().getSelectedValue();
        ArrayList<String> studentList = studentDatabase.getStudentBySection(teacher.getName(),section);
        classroomCard.getSection().getList().addAllToList(studentList);
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
