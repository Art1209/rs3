package rs3.persistence.service.serviceInterf;


import rs3.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void delete(long id);
    Employee getByName(String name);
    void editEmployee(Employee employee);
    List<Employee> getAll();
}
