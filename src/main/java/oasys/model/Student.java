package oasys.model;

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
}
