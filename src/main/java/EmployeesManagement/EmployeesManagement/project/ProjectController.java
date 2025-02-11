package EmployeesManagement.EmployeesManagement.project;

import EmployeesManagement.EmployeesManagement.configuration.NotFoundInDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<?>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProject(@PathVariable Long id) throws NotFoundInDatabaseException {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public ResponseEntity<?> creatProject(@RequestBody ProjectRequest request) {
        return ResponseEntity.ok(projectService.crateProject(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody ProjectRequest request) throws NotFoundInDatabaseException {
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) throws NotFoundInDatabaseException {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
