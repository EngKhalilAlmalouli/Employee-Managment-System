package EmployeesManagement.EmployeesManagement.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("x")
//    public String findAllEmployees() {
//        return employeeService.GetEmployee();
//    }
    @GetMapping("allemployees")
    private List<Employee> getAllEmployees() {
        return employeeService.allEmployees();
    }


    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
//        System.out.println(employee.getEmail());
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }


    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable Long id , @RequestBody Employee request){
//        request.getName();
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("{id}")
    public Map<String , Object> deleteEmployee(@PathVariable Long id) {
        Map<String , Object > map = new HashMap<>();
        map.put("message" , employeeService.deleteEmployee(id));
        return map;
    }
}
