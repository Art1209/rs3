package rs3.tools.dbInitImpl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs3.persistence.entity.Department;
import rs3.persistence.entity.Employee;
import rs3.persistence.service.serviceInterf.DepartmentService;
import rs3.persistence.service.serviceInterf.EmployeeService;
import rs3.tools.dbInitInterf.DbInitializr;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

@Component
public class DbInitializrFromJsonImpl implements DbInitializr {

    @Autowired
    private DepartmentService depService;

    @Autowired
    private EmployeeService empService;

    @Override
    public void initialize(InputStreamReader source) {
        ArrayList<Department> deps = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray departments = (JSONArray) parser.parse(source);
            for (Object obj : departments) {
                JSONObject depObj = (JSONObject) obj;
                String depName = (String) depObj.get("name");
                ArrayList<Map<String, String>> emps = (ArrayList<Map<String, String>>) depObj.get("employeesList");
                ArrayList<Employee> employees = new ArrayList<>();

                Department dep = new Department();
                dep.setDepartmentName(depName);
                depService.addDepartment(dep);

                for (Map<String, String> tempMap : emps) {
                    String empName = tempMap.get("name");
                    Double empSalary = Double.parseDouble(tempMap.get("salary"));
                    Employee emp = new Employee(empSalary, empName);
                    emp.setDepartment(dep);
                    employees.add(emp);
                    empService.addEmployee(emp);
                }

                dep.setEmployeesList(employees);
                dep.setAvgSalary(dep.getAvgSalary());
                depService.editDepartment(dep);
                deps.add(dep);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
