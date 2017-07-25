package rs3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs3.persistence.entity.Department;
import rs3.persistence.entity.Employee;
import rs3.persistence.entity.User;
import rs3.persistence.service.serviceInterf.DepartmentService;
import rs3.persistence.service.serviceInterf.EmployeeService;
import rs3.persistence.service.serviceInterf.UserService;
import rs3.tools.customObjectSerializer.DepartmentsXmlResponse;
import rs3.tools.customObjectSerializer.EmployeesXmlResponse;


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
    @Autowired
    UserService userService;

    @RequestMapping(value = GET_DEP, method = RequestMethod.GET)
    public @ResponseBody Department getDep(@PathVariable(value = "id")int id){
        Department dep = depService.getByName(""+id);
        return dep;
    }

    @RequestMapping(value = UPDATE_DEP, method = RequestMethod.PUT)
    public @ResponseBody void updateDep(@RequestBody Department dep){
        depService.editDepartment(dep);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = GET_ALL_DEP, method = RequestMethod.GET)
    public @ResponseBody
    DepartmentsXmlResponse getAllDep(){
        DepartmentsXmlResponse container = new DepartmentsXmlResponse();
        container.setDepartments(depService.getAll());
        return container ;
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
    public @ResponseBody EmployeesXmlResponse getAllEmp(){
        EmployeesXmlResponse container = new EmployeesXmlResponse();
        container.setEmployees(empService.getAll());
        return container ;
    }

    @RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
    public void createEmp(@RequestBody Employee emp){
        empService.addEmployee(emp);
    }

    @RequestMapping(value = DELETE_EMP, method = RequestMethod.GET)
    public @ResponseBody void deleteEmp(@PathVariable(value = "id")int id){
        empService.delete(id);
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody User getUser(){
        return userService.getUser("login");
    }

}
