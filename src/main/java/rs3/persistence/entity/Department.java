package rs3.persistence.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import rs3.tools.EntityUtils;
import rs3.tools.customObjectSerializer.CustomObjectEmployeeListSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "department")
@Entity
@Table(name="department")
public class Department implements Serializable{

    @Id
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
    private double avgSalary;
    public double getAvgSalary() {
        return EntityUtils.getAverageSalary(this);
    }
    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }


    @JsonSerialize(using= CustomObjectEmployeeListSerializer.class)
    @OneToMany(targetEntity=Employee.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Employee> employeesList=new ArrayList<>();

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
//    @XmlJavaTypeAdapter(value = EmployeesListXmlAdapter.class) // Чтобы выводить список в едином корневоом элементе
    public List<Employee> getEmployeesList() {
        return employeesList;
    }
    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public Department() {
    }
}
