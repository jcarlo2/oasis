package oasys.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConcernReport {
    private String studentName;
    private String studentId;
    private String adviser;
    private String subject;
    private String detail;
    private String reportId;
    private String status;
    private String type;
}
