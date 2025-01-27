package EmployeesManagement.EmployeesManagement.employee;

//import EmployeesManagement.EmployeesManagement.department.Department;
import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Data
@Table(name = "EMPLOYEES")
public class Employee {
   @Id
   @GeneratedValue
   private long id;
   private String name;
   @Column(unique=true, name = "phone")
   private String phone;
   @Column(unique=true, name = "email")
   private String email;


//   @ManyToOne
//   private Department department;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }


}
