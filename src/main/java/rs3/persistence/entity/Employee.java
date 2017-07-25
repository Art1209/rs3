package rs3.persistence.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import rs3.tools.customObjectSerializer.CustomObjectDepartmentSerializer;
import rs3.tools.customObjectSerializer.DepartmentXmlAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlRootElement(name = "employee")
@Entity
@Table(name="employee")
public class Employee implements Serializable{

    @Id
    @Column(name = "id", length = 6, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer employeeId;
    public int getEmployeeId(){return this.employeeId;}
    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    @Column(name = "salary")
    private double salary;
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Column(name = "employee_name")
    private String employeeName;
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String name) {
        this.employeeName = name;
    }


    @JsonSerialize(using= CustomObjectDepartmentSerializer.class)
    @ManyToOne
    @JoinColumn(name="department", nullable = false)
    private Department department;

    @XmlJavaTypeAdapter(value = DepartmentXmlAdapter.class) // Чтобы остановить рекурсию при выводе связанных классов в xml
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name = "can_be_transferred")
    private boolean canBeTransferred;
    public void setCanBeTransferred(boolean canBeTransferred) {
        this.canBeTransferred = canBeTransferred;
    }
    public boolean isCanBeTransferred() {
        return canBeTransferred;
    }

    public Employee(double salary, String employeeName) {
        this.salary = salary;
        this.employeeName = employeeName;
    }

    public Employee() {
    }
    }
