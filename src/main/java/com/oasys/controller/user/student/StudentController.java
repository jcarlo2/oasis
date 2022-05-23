package com.oasys.controller.user.student;

import com.oasys.controller.database.AnnouncementDatabase;
import com.oasys.controller.database.ConcernReportDatabase;
import com.oasys.controller.database.TeacherDatabase;
import com.oasys.dto.ConcernReport;
import com.oasys.controller.database.StudentDatabase;
import com.oasys.shared.customcomponent.CustomJTextPane;
import com.oasys.model.Student;
import com.oasys.shared.util.Dialog;
import com.oasys.view.BuildGUI;
import com.oasys.view.student.StudentPanel;
import com.oasys.view.student.panel.account.Account;
import com.oasys.view.student.panel.account.MailBox;
import com.oasys.view.student.panel.dashboard.DashboardCard;
import com.oasys.view.student.panel.teacher.Concern;
import com.oasys.view.student.panel.teacher.Teacher;
import com.oasys.view.student.panel.teacher.TeacherCard;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StudentController {
    private final AnnouncementDatabase announcementDatabase = new AnnouncementDatabase();
    private final ConcernReportDatabase concernReportDatabase = new ConcernReportDatabase();
    private final StudentDatabase studentDatabase = new StudentDatabase();
    private final TeacherDatabase teacherDatabase = new TeacherDatabase();
    private final DashboardCard dashboardCard;
    private final StudentPanel studentPanel;
    private final Account account;
    private final MailBox mailBox;
    private final Teacher teacher;
    private final TeacherCard teacherCard;
    private final Concern concern;
    private final BuildGUI buildGUI;
    private Student student;
    private int boardNum = 0;

    public StudentController(@NotNull BuildGUI buildGUI, Student student) {
        this.student = student;
        this.buildGUI = buildGUI;
        this.studentPanel = buildGUI.getStudentFrame().getStudentPanel();
        account = studentPanel.getAccount().getAccount();
        dashboardCard = studentPanel.getDashboard();
        teacher = studentPanel.getTeacher().getTeacher();
        teacherCard = studentPanel.getTeacher();
        concern = studentPanel.getTeacher().getConcern();
        mailBox = studentPanel.getAccount().getMailBox();
        updateData();
        announcementBoardBackListener();
        addMouseListenerToDashboard();
        addActionListenerToConcern();
        addActionListenerToTab();
        addConcernReport();
        setLogOut();
        nextAnnouncement();
        prevAnnouncement();
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

    private void updateData() {
        Runnable runnable = () -> {
            if(student.getId() != null) {
                addStudentInformationToTable();
                setDashboardTitle();
                getAdviser();
                concernAutoFillUp();
                getConcernReportToMailBox();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    private void addStudentInformationToTable() {
        if(account.getTable().getRowCount() == 0) account.getTable().addStudentInformation(student);
        if(!isSameData(student)) {
            student = studentDatabase.getStudentInformation(student.getId());
            account.getTable().addStudentInformation(student);
        }
    }

    private boolean isSameData(@NotNull Student student) {
        return student.equals(studentDatabase.getStudentInformation(student.getId()));
    }

    private void concernAutoFillUp() {
        if(concern.getStudentField().getText().equals(student.getName()) && concern.getTeacherField().getText().equals(student.getAdviser())) return;
        concern.getStudentField().setText(student.getName());
        concern.getTeacherField().setText(student.getAdviser());
    }

    private void getConcernReportToMailBox() {
        ArrayList<ConcernReport> reportList = concernReportDatabase.getConcernReport(student.getName());
        if(reportList.size() == mailBox.getTable().getRowCount()) return;
        mailBox.getTable().addRowMailBox(reportList);
    }

    private void addConcernReport() {
        concern.getSubmit().addActionListener(e -> {
            if(isErrorInput()) return;
            concernReportDatabase.addConcernReport(createConcernReport());
            concern.getReportId().setText(generateReportId());
            Dialog.SUBMIT_SUCCESSFUL();
        });
    }

    @Contract(" -> new")
    private @NotNull ConcernReport createConcernReport() {
        return new ConcernReport(concern.getStudentField().getText(),
                                    student.getId(),
                                      concern.getTeacherField().getText(),
                                      concern.getSubjectField().getText(),
                                       concern.getTextArea().getText(),
                                     concern.getReportId().getText(),"",
            Objects.requireNonNull(concern.getComboBox().getSelectedItem()).toString());
    }

    private boolean isErrorInput() {
        if(concern.getTextArea().getText().equals("") || concern.getSubjectField().getText().equals("")) {
            Dialog.EMPTY_FIELD();
            return true;
        }
        if(concernReportDatabase.isIdExist(concern.getReportId().getText())) {
            Dialog.GENERATE_NEW_ID();
            return true;
        }
        return false;
    }

    private @NotNull String generateReportId() {
        long id;
        String formatId = "";
        boolean flag = true;
        while(flag) {
            id = (long) (Math.random() * 10000000000L);
            formatId = String.format("%011d",id);
            if(!concernReportDatabase.isIdExist(formatId)) flag = false;
        }
        return formatId;
    }

    private void getAdviser() {
        if(teacher.getTeacherName().getText().equals(student.getAdviser())) return;
        teacher.getTeacherName().setText(student.getAdviser());
    }

    private void setDashboardTitle() {
        String adviserId = teacherDatabase.getAdviserId(student.getAdviser());
        String[] data = announcementDatabase.getTitle(adviserId);
        dashboardCard.getDashboard().getDashOne().setText(data[0]);
        dashboardCard.getDashboard().getDashTwo().setText(data[1]);
        dashboardCard.getDashboard().getDashThree().setText(data[2]);
        dashboardCard.getDashboard().getDashFour().setText(data[3]);
        dashboardCard.getDashboard().getDashFive().setText(data[4]);
        dashboardCard.getDashboard().getDashSix().setText(data[5]);
    }


    private void setAnnouncementTitleAndDetail(int num) {
        String adviserId = teacherDatabase.getAdviserId(student.getAdviser());
        String[] detail = announcementDatabase.getDetail(adviserId);
        String[] title = announcementDatabase.getTitle(adviserId);
        for(int i=0;i<detail.length;i++) {
            if(num == i) dashboardCard.getAnnouncementBoard().getTextArea().setText(detail[i]);
            if(num == i) dashboardCard.getAnnouncementBoard().getTitle().setText(title[i]);
        }
    }

    private void addMouseListener(@NotNull CustomJTextPane dash, int num) {
        dash.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitleAndDetail(num);
                    boardNum = num;
                }
            }
        });
    }
    
    private void addMouseListenerToDashboard() {
        final int DASHBOARD_QUANTITY = 6;
        for(int i=0;i<DASHBOARD_QUANTITY;i++) addMouseListener(dashboardCard.getDashboard().getDashList().get(i),i);
    }

    private void announcementBoardBackListener() {
        dashboardCard.getAnnouncementBoard().getBack().addActionListener(e -> dashboardCard.getCard().show(dashboardCard,"dashboard"));
    }

    private void addActionListenerToConcern() {
        teacher.getConcernBtn().addActionListener(e -> {
            teacherCard.getCard().show(teacherCard,"concern");
            concern.getReportId().setText(generateReportId());
            concern.getSubjectField().setText("");
            concern.getTextArea().setText("");
        });
        concern.getBack().addActionListener(e -> teacherCard.getCard().show(teacherCard,"teacher"));
    }

    private void addActionListenerToTab() {
        studentPanel.getAccountBtn().addActionListener(e -> {
            if(e.getSource() == studentPanel.getAccountBtn()) {
                studentPanel.getCard().show(studentPanel.getCenter(),"account");
                studentPanel.getDashboard().getCard().show(studentPanel.getDashboard(),"dashboard");
                studentPanel.getTeacher().getCard().show(studentPanel.getTeacher(),"teacher");
                studentPanel.getAccountBtn().setEnabled(false);
                studentPanel.getDashboardBtn().setEnabled(true);
                studentPanel.getTeacherBtn().setEnabled(true);
            }
        });

        studentPanel.getDashboardBtn().addActionListener(e -> {
            if(e.getSource() == studentPanel.getDashboardBtn()) {
                studentPanel.getCard().show(studentPanel.getCenter(),"dashboard");
                studentPanel.getAccount().getCard().show(studentPanel.getAccount(),"account");
                studentPanel.getAccountBtn().setEnabled(true);
                studentPanel.getDashboardBtn().setEnabled(false);
                studentPanel.getTeacherBtn().setEnabled(true);
            }
        });

        studentPanel.getTeacherBtn().addActionListener(e -> {
            if(e.getSource() == studentPanel.getTeacherBtn()) {
                studentPanel.getCard().show(studentPanel.getCenter(),"teacher");
                studentPanel.getDashboard().getCard().show(studentPanel.getDashboard(),"dashboard");
                studentPanel.getAccount().getCard().show(studentPanel.getAccount(),"account");
                studentPanel.getAccountBtn().setEnabled(true);
                studentPanel.getDashboardBtn().setEnabled(true);
                studentPanel.getTeacherBtn().setEnabled(false);
            }
        });
    }

    private void setLogOut() {
        account.getLogOut().addActionListener(e -> {
            buildGUI.getLogInFrame().getLogInPanel().getUsername().setText("Username");
            buildGUI.getLogInFrame().getLogInPanel().getPassword().setText("password");
            buildGUI.getStudentFrame().setVisible(false);
            buildGUI.getLogInFrame().setVisible(true);
        });
    }
}
