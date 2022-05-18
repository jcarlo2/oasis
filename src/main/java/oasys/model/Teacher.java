package oasys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
public class Teacher {
    private String id;
    private String name;
    private String email;
    private String campus;
    private String department;
    private String consultationHours;
    private String year;
    private ArrayList<String> advisoryClass;

    public Teacher() {}

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Teacher teacher)) return false;
        return getId().equals(teacher.getId()) && getName().equals(teacher.getName()) &&
                getEmail().equals(teacher.getEmail()) && getCampus().equals(teacher.getCampus()) &&
                getDepartment().equals(teacher.getDepartment()) && getConsultationHours().equals(teacher.getConsultationHours()) &&
                getYear().equals(teacher.getYear()) && getAdvisoryClass().equals(teacher.getAdvisoryClass());
    }
}
