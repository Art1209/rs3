package rs3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs3.persistence.entity.Department;
import rs3.persistence.entity.Employee;
import rs3.persistence.service.serviceInterf.DepartmentService;
import rs3.persistence.service.serviceInterf.EmployeeService;

import java.util.List;


@Controller
@RequestMapping("/api")
public class MainApiController {
    public static final String GET_DEP = "/department/{id}";
    public static final String GET_ALL_DEP = "/department/departments";
    public static final String CREATE_DEP = "/department/create";
    public static final String UPDATE_DEP = "/department/update";
    public static final String DELETE_DEP = "/department/delete/{id}";

    public static final String GET_EMP = "/employee/{id}";
    public static final String GET_ALL_EMP = "/employee/employees";
    public static final String UPDATE_EMP = "/employee/update";
    public static final String CREATE_EMP = "/employee/create";
    public static final String DELETE_EMP = "/employee/delete/{id}";

    @Autowired
    DepartmentService depService;
    @Autowired
    EmployeeService empService;

    @RequestMapping(value = GET_DEP, method = RequestMethod.GET)
    public @ResponseBody Department getDep(@PathVariable(value = "id")int id){
        return depService.getByName(""+id);
    }
    @RequestMapping(value = UPDATE_DEP, method = RequestMethod.PUT)
    public @ResponseBody void updateDep(@RequestBody Department dep){
        depService.editDepartment(dep);
    }
    @RequestMapping(value = GET_ALL_DEP, method = RequestMethod.GET)
    public @ResponseBody List<Department> getAllDep(){
        return depService.getAll();
    }
    @RequestMapping(value = CREATE_DEP, method = RequestMethod.POST)
    public void createDep(@RequestBody Department dep){
        depService.addDepartment(dep);
    }
    @RequestMapping(value = DELETE_DEP, method = RequestMethod.GET)
    public @ResponseBody void deleteDep(@PathVariable(value = "id")int id){
        depService.delete(id);
    }

    @RequestMapping(value = GET_EMP, method = RequestMethod.GET)
    public @ResponseBody
    Employee getEmp(@PathVariable(value = "id")int id){
        return empService.getByName(""+id);
    }
    @RequestMapping(value = UPDATE_EMP, method = RequestMethod.PUT)
    public @ResponseBody void updateEmp(@RequestBody Employee emp){
        empService.editEmployee(emp);
    }
    @RequestMapping(value = GET_ALL_EMP, method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmp(){
        return empService.getAll();
    }
    @RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
    public void createEmp(@RequestBody Employee emp){
        empService.addEmployee(emp);
    }
    @RequestMapping(value = DELETE_EMP, method = RequestMethod.GET)
    public @ResponseBody void deleteEmp(@PathVariable(value = "id")int id){
        empService.delete(id);
    }


}
