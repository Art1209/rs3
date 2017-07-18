package rs3.persistence.entity;


import rs3.tools.EntityUtils;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
public class Department {

    @Id
//    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "department_id", length = 6, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "department_name")
    private String departmentName;
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Column(name = "avgsalary")
    private double avgSalary=0f;
    public double getAvgSalary() {
        return EntityUtils.getAverageSalary(this);
    }
    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    @OneToMany(targetEntity=Employee.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Employee> employeesList=new ArrayList<>();
    public List<Employee> getEmployeesList() {
        return employeesList;
    }
    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public Department() {
    }
}
