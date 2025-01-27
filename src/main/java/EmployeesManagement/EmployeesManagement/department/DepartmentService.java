package EmployeesManagement.EmployeesManagement.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartmentById(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department request) {

        Department updateDepartment = departmentRepository.findById(id).orElse(null);

        updateDepartment.setName(request.getName());
        updateDepartment.setDescription(request.getDescription());


        return departmentRepository.save(updateDepartment);
    }


    public String deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted successfully";
    }


}
