package rs3.persistence.service.RepoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs3.persistence.DAO.repository.DepartmentRepository;
import rs3.persistence.entity.Department;
import rs3.persistence.service.interf.DepartmentService;

import java.util.List;

//@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void addDepartment(Department department) {
        departmentRepository.saveAndFlush(department);
    }

    @Override
    public void delete(long id) {
        departmentRepository.delete(id);
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public void editDepartment(Department department) {
        departmentRepository.saveAndFlush(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}