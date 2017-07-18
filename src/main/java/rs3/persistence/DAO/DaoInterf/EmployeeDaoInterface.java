package rs3.persistence.DAO.DaoInterf;


import rs3.persistence.entity.Employee;

import java.util.List;

public interface EmployeeDaoInterface {
    void addEmployee(Employee emp);
    void removeEmployee(int id);
    void updateEmployee(Employee emp);
    List<Employee> getAll();
    Employee getEmployeeById(int id);
}
