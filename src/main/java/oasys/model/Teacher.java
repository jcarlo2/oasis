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
}
