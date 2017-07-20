package rs3.soap.repositoryAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs3.persistence.entity.Employee;
import rs3.persistence.service.serviceInterf.EmployeeService;
import rs3.soap.EmployeeFromXsd;

@Component
public class SoapEmployeeRepositoryAdapter {
    @Autowired
    EmployeeService empService;

    public EmployeeFromXsd findEmployeeFromXsd(int id){
        Employee emp = empService.getByName(""+id);
        EmployeeFromXsd empFromXsd = new EmployeeFromXsd();
        empFromXsd.setEmployeeId(id);
        empFromXsd.setEmployeeName(emp.getEmployeeName());
        empFromXsd.setSalary(emp.getSalary());
        empFromXsd.setDepartment(emp.getDepartment().toString());
        return empFromXsd;
    }
}
