package rs3.persistence.service.RepoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs3.persistence.DAO.repository.EmployeeRepository;
import rs3.persistence.entity.Employee;
import rs3.persistence.service.interf.EmployeeService;

import java.util.List;

//@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee getByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}