package EmployeesManagement.EmployeesManagement.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class ProjectResponse {

    private Long id;
    private String projectName;
}
