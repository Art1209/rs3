package rs3.persistence.service.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs3.persistence.DAO.daoInterf.EmployeeDaoInterface;
import rs3.persistence.entity.Employee;
import rs3.persistence.service.serviceInterf.EmployeeService;

import java.util.List;

@Service
public class EmployeeDaoService implements EmployeeService{
    private EmployeeDaoInterface employeeDAO;

    @Autowired(required = true)
    public void setDepartmentDAO(EmployeeDaoInterface employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public void addEmployee(Employee emp) {
        this.employeeDAO.addEmployee(emp);
    }

    @Transactional
    @Override
    public Employee getByName(String name) {
        return this.employeeDAO.getEmployeeById(new Integer(name));
    }

    @Transactional
    @Override
    public void editEmployee(Employee employee) {
        this.employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return this.employeeDAO.getAll();
    }

    @Transactional
    public Employee getDepartmentById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Transactional
    public void delete(long id) {
        this.employeeDAO.removeEmployee((int)id);
    }
}
