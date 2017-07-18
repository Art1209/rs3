package rs3.tools;

import rs3.persistence.entity.Department;
import rs3.persistence.entity.Employee;

public class EntityUtils {
    public static double getAverageSalary(Department dep) {
        double tempSum = 0;
        for (Employee i:dep.getEmployeesList()){
            tempSum += i.getSalary();

        }
        double tempAvgSalary = tempSum/dep.getEmployeesList().size();
        return tempAvgSalary;
    }
    public static String departmentToString(Department dep){
        String lineSeparator = System.getProperty("line.separator");
        String empsAsString = "";
        for (Employee emp: dep.getEmployeesList()) {
            empsAsString+=employeeToString(emp);
        }
        return "Отдел: "+dep.getDepartmentName()+lineSeparator + "Средняя зарплата: "+dep.getAvgSalary()+ lineSeparator +empsAsString+lineSeparator;
    }
    public static String employeeToString(Employee emp){
        String lineSeparator = System.getProperty("line.separator");
        return "Имя: "+ emp.getEmployeeName() +lineSeparator+"Зарплата: "+ emp.getSalary() +lineSeparator;
    }
}
