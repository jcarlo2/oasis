package oasys.util;

public class TableCreatorImpl implements TableCreator{
    public TableCreatorImpl() {
        createStudentTable();
        createUserTable();
        createConcernReport();
        createAnnouncementHistoryTable();
        createTeacherTable();
        createAdvisoryClassTable();
    }
}
