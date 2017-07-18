package rs3.persistence.DAO.DaoInterf;

import rs3.persistence.entity.Department;

import java.util.List;


public interface DepartmentDaoInterface {
    void addDepartment(Department department);
    void removeDepartment(int id);
    void updateDepartment(Department department);
    List<Department> getAll();
    Department getDepartmentById(int id);

}
