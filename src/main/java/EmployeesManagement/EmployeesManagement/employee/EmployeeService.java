package EmployeesManagement.EmployeesManagement.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        System.out.println(employee.getName());
        return employeeRepository.save(employee);
    }
    public Employee getEmployee(Long id) {
//        Employee getEmployee = employeeRepository.findById(id).orElse(null);

        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee request){

        Employee updateEmployee = employeeRepository.findById(id).orElse(null);

        updateEmployee.setName(request.getName());
        updateEmployee.setPhone(request.getPhone());
        updateEmployee.setEmail(request.getEmail());

        return employeeRepository.save(updateEmployee);
    }

    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }


}
