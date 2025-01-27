package EmployeesManagement.EmployeesManagement.department;

import EmployeesManagement.EmployeesManagement.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("{id}")
    public Department updateDepartment(@PathVariable Long id , @RequestBody Department request){
        return departmentService.updateDepartment(id, request);
    }

    @DeleteMapping("{id}")
    public Map<String , Object> deleteDepartment(@PathVariable Long id) {
        Map<String , Object > map = new HashMap<>();
        map.put("message" , departmentService.deleteDepartment(id));
        return map;
    }
}
