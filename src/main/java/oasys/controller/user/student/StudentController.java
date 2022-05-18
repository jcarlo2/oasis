package oasys.controller.user.student;

import oasys.controller.database.AnnouncementDatabase;
import oasys.controller.database.ConcernReportDatabase;
import oasys.controller.database.StudentDatabase;
import oasys.model.Student;
import oasys.model.dto.ConcernReport;
import oasys.util.Dialog;
import oasys.view.BuildGUI;
import oasys.view.student.StudentPanel;
import oasys.view.student.panel.account.Account;
import oasys.view.student.panel.account.MailBox;
import oasys.view.student.panel.dashboard.DashboardCard;
import oasys.view.student.panel.teacher.Concern;
import oasys.view.student.panel.teacher.Teacher;
import oasys.view.student.panel.teacher.TeacherCard;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StudentController {
    private final AnnouncementDatabase announcementDatabase = new AnnouncementDatabase();
    private final ConcernReportDatabase concernReportDatabase = new ConcernReportDatabase();
    private final StudentDatabase studentDatabase = new StudentDatabase();
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
                setAnnouncementDetail(0);
                setAnnouncementTitle(0);
                boardNum = 0;
                return;
            }
            boardNum++;
            setAnnouncementDetail(boardNum);
            setAnnouncementTitle(boardNum);
        });
    }

    private void prevAnnouncement() {
        dashboardCard.getAnnouncementBoard().getPrevious().addActionListener(e -> {
            if(boardNum <= 0) {
                setAnnouncementDetail(5);
                setAnnouncementTitle(5);
                boardNum = 5;
                return;
            }
            boardNum--;
            setAnnouncementDetail(boardNum);
            setAnnouncementTitle(boardNum);
        });
    }

    private void updateData() {
        Runnable runnable = () -> {
            if(student.getId() != null) {
                addStudentInformationToTable();
                getTitle();
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
        if(concern.getStudentField().getText().equals(student.getName()) &&
                    concern.getTeacherField().getText().equals(student.getAdviser())) return;
        concern.getStudentField().setText(student.getName());
        concern.getTeacherField().setText(student.getAdviser());
    }

    private void getConcernReportToMailBox() {
        mailBox.getTable().addRowMailBox(concernReportDatabase.getConcernReport(student.getName()));
    }

    private void addConcernReport() {
        concern.getSubmit().addActionListener(e -> {
            if(concern.getTextArea().getText().equals("") || concern.getSubjectField().getText().equals("")) {
                Dialog.EMPTY_FIELD();
                return;
            }
            if(concernReportDatabase.isIdExist(concern.getReportId().getText())) {
                Dialog.GENERATE_NEW_ID();
                return;
            }
            ConcernReport report = new ConcernReport(concern.getStudentField().getText(),
                    student.getId(),concern.getTeacherField().getText(),
                    concern.getSubjectField().getText(),concern.getTextArea().getText(),
                    concern.getReportId().getText(),"");
            concernReportDatabase.addConcernReport(report);
            concern.getReportId().setText(generateReportId());
            Dialog.SUBMIT_SUCCESSFUL();
        });
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

    private void getTitle() {
        String[] data = announcementDatabase.getTitle(student.getAdviser());
        dashboardCard.getDashboard().getDashOne().setText(data[0]);
        dashboardCard.getDashboard().getDashTwo().setText(data[1]);
        dashboardCard.getDashboard().getDashThree().setText(data[2]);
        dashboardCard.getDashboard().getDashFour().setText(data[3]);
        dashboardCard.getDashboard().getDashFive().setText(data[4]);
        dashboardCard.getDashboard().getDashSix().setText(data[5]);
    }

    private void setAnnouncementTitle(int num) {
        String[] data = announcementDatabase.getTitle(student.getAdviser());
        if(num == 0) dashboardCard.getAnnouncementBoard().getTitle().setText(data[0]);
        if(num == 1) dashboardCard.getAnnouncementBoard().getTitle().setText(data[1]);
        if(num == 2) dashboardCard.getAnnouncementBoard().getTitle().setText(data[2]);
        if(num == 3) dashboardCard.getAnnouncementBoard().getTitle().setText(data[3]);
        if(num == 4) dashboardCard.getAnnouncementBoard().getTitle().setText(data[4]);
        if(num == 5) dashboardCard.getAnnouncementBoard().getTitle().setText(data[5]);
    }

    private void setAnnouncementDetail(int num) {
        String[] data = announcementDatabase.getDetail(student.getAdviser());
        if(num == 0) dashboardCard.getAnnouncementBoard().getTextArea().setText(data[0]);
        if(num == 1) dashboardCard.getAnnouncementBoard().getTextArea().setText(data[1]);
        if(num == 2) dashboardCard.getAnnouncementBoard().getTextArea().setText(data[2]);
        if(num == 3) dashboardCard.getAnnouncementBoard().getTextArea().setText(data[3]);
        if(num == 4) dashboardCard.getAnnouncementBoard().getTextArea().setText(data[4]);
        if(num == 5) dashboardCard.getAnnouncementBoard().getTextArea().setText(data[5]);
    }
    
    private void addMouseListenerToDashboard() {
        dashboardCard.getAnnouncementBoard().getBack().addActionListener(e -> dashboardCard.getCard().show(dashboardCard,"dashboard"));

        dashboardCard.getDashboard().getDashOne().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitle(0);
                    setAnnouncementDetail(0);
                    boardNum = 0;
                }
            }
        });

        dashboardCard.getDashboard().getDashTwo().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitle(1);
                    setAnnouncementDetail(1);
                    boardNum = 1;
                }

            }
        });

        dashboardCard.getDashboard().getDashThree().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitle(2);
                    setAnnouncementDetail(2);
                    boardNum = 2;
                }
            }
        });

        dashboardCard.getDashboard().getDashFour().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitle(3);
                    setAnnouncementDetail(3);
                    boardNum = 3;
                }
            }
        });

        dashboardCard.getDashboard().getDashFive().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitle(4);
                    setAnnouncementDetail(4);
                    boardNum = 4;
                }
            }
        });

        dashboardCard.getDashboard().getDashSix().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getClickCount() == 2) {
                    dashboardCard.getCard().show(e.getComponent().getParent().getParent(),"announcement");
                    setAnnouncementTitle(5);
                    setAnnouncementDetail(5);
                    boardNum = 5;
                }
            }
        });
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
                studentPanel.getAccountBtn().setEnabled(false);
                studentPanel.getDashboardBtn().setEnabled(true);
                studentPanel.getTeacherBtn().setEnabled(true);
            }
        });

        studentPanel.getDashboardBtn().addActionListener(e -> {
            if(e.getSource() == studentPanel.getDashboardBtn()) {
                studentPanel.getCard().show(studentPanel.getCenter(),"dashboard");
                studentPanel.getAccountBtn().setEnabled(true);
                studentPanel.getDashboardBtn().setEnabled(false);
                studentPanel.getTeacherBtn().setEnabled(true);
            }
        });

        studentPanel.getTeacherBtn().addActionListener(e -> {
            if(e.getSource() == studentPanel.getTeacherBtn()) {
                studentPanel.getCard().show(studentPanel.getCenter(),"teacher");
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
