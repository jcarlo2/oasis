package com.oasys.shared.util;

public class TableCreatorImpl implements TableCreator{
    public TableCreatorImpl() {
        createSchema();
        createStudentTable();
        createUserTable();
        createConcernReport();
        createAnnouncementHistoryTable();
        createTeacherTable();
        createAdvisoryClassTable();
    }
}
