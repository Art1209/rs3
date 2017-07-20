package rs3.persistence.service.serviceInterf;


import rs3.persistence.entity.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    void delete(long id);
    Department getByName(String name);
    void editDepartment(Department department);
    List<Department> getAll();
}
