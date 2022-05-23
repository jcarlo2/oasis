package com.oasys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private String email;
    private String campus;
    private String academicLevel;
    private String section;
    private String program;
    private String yearLevel;
    private String adviser;

    public Student() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getId().equals(student.getId()) && getName().equals(student.getName()) &&
                getEmail().equals(student.getEmail()) && getCampus().equals(student.getCampus()) &&
                getAcademicLevel().equals(student.getAcademicLevel()) && getSection().equals(student.getSection()) &&
                getProgram().equals(student.getProgram()) && getYearLevel().equals(student.getYearLevel()) &&
                getAdviser().equals(student.getAdviser());
    }
}
