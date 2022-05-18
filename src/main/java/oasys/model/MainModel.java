package oasys.model;

import lombok.Getter;

@Getter
public class MainModel {
    private final Student student = new Student();
    private final Teacher teacher = new Teacher();
}
