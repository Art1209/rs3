package rs3.persistence.service.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs3.persistence.DAO.daoInterf.DepartmentDaoInterface;
import rs3.persistence.entity.Department;
import rs3.persistence.service.serviceInterf.DepartmentService;

import java.util.List;

@Service
public class DepartmentDaoServiceImpl implements DepartmentService{
    private DepartmentDaoInterface departmentDAO;

    @Autowired(required = true)
    public void setDepartmentDAO(DepartmentDaoInterface departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Transactional
    public void addDepartment(Department dep) {
        this.departmentDAO.addDepartment(dep);
    }

    @Transactional
    @Override
    public Department getByName(String name) {
        return this.departmentDAO.getDepartmentById(new Integer(name));
    }

    @Transactional
    @Override
    public void editDepartment(Department department) {
        this.departmentDAO.updateDepartment(department);
    }

    @Override
    @Transactional
    public List<Department> getAll() {
        return this.departmentDAO.getAll();
    }

    @Transactional
    public Department getDepartmentById(int id) {
        return this.departmentDAO.getDepartmentById(id);
    }

    @Transactional
    public void delete(long id) {
        this.departmentDAO.removeDepartment((int)id);
    }

}
