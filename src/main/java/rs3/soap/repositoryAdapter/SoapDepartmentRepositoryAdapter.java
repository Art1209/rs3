package rs3.soap.repositoryAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs3.persistence.entity.Department;
import rs3.persistence.service.serviceInterf.DepartmentService;
import rs3.soap.DepartmentFromXsd;

@Component
public class SoapDepartmentRepositoryAdapter {
    @Autowired
    DepartmentService depService;

    public DepartmentFromXsd findDepartmentFromXsd(int id){
        Department dep = depService.getByName(""+id);
        DepartmentFromXsd depFromXsd = new DepartmentFromXsd();
        depFromXsd.setDepartmentId(id);
        depFromXsd.setDepartmentName(dep.getDepartmentName());
        depFromXsd.setAvgSalary(dep.getAvgSalary());
        depFromXsd.setEmployeesList(dep.getEmployeesList().toString());
        return depFromXsd;
    }

}
