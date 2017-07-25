package rs3.tools.customObjectSerializer;

import rs3.persistence.entity.Employee;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.List;


public class EmployeesListXmlAdapter extends XmlAdapter {
    @Override
    public Object unmarshal(Object v) throws Exception {
        EmployeesXmlResponse empsContainer = (EmployeesXmlResponse) v;
        return empsContainer.getEmployees();

    }

    @Override
    public Object marshal(Object v) throws Exception {
        List<Employee> emps = (List<Employee>)v;
        EmployeesXmlResponse empsContainer = new EmployeesXmlResponse();
        empsContainer.setEmployees(emps);
        return empsContainer;
    }
}
