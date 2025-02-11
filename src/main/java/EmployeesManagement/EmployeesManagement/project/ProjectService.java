package EmployeesManagement.EmployeesManagement.project;

import EmployeesManagement.EmployeesManagement.configuration.NotFoundInDatabaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;


    public List<?> getAllProjects() {
        return projectRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public ResponseEntity<?> getProjectById(Long id) throws NotFoundInDatabaseException {
        Project project = projectRepository.findById(id).orElseThrow(() -> new NotFoundInDatabaseException("project not found"));

        ProjectResponse response = mapToResponse(project);
        return ResponseEntity.status(HttpStatus.OK).body(response);


//        Project project = projectRepository.findById(id).orElse(null);
//        if (project == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("project not found");
//        }
//        ProjectResponse response = ProjectResponse.builder()
//                .id(project.getId())
//                .projectName(project.getPrjectName())
//                .build();
//        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public ResponseEntity<?> crateProject(ProjectRequest request) {
        Project project = Project.builder()
                .prjectName(request.getProjectName())
                .build();

        ProjectResponse response = ProjectResponse.builder()
                .id(project.getId())
                .projectName(request.getProjectName())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Transactional
    public ProjectResponse updateProject(Long id, ProjectRequest request) throws NotFoundInDatabaseException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("project not found"));
        project.setPrjectName(request.getProjectName());

        project = projectRepository.save(project);
        return mapToResponse(project);
    }

    public ResponseEntity<?> deleteProject(Long id) throws NotFoundInDatabaseException {
        Project project = projectRepository.findById(id).orElseThrow(() -> new NotFoundInDatabaseException("project not found"));
        if (project == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("project not found");
        }
        projectRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private ProjectResponse mapToResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .projectName(project.getPrjectName())
                .build();

    }
}
