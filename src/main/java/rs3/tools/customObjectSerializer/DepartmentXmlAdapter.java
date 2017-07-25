package rs3.tools.customObjectSerializer;

import rs3.persistence.entity.Department;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class DepartmentXmlAdapter extends XmlAdapter {
    @Override
    public Object unmarshal(Object v) throws Exception {
        String name = (String) v;
        Department dep = new Department();
        dep.setDepartmentName(name);
        return dep;
    }

    @Override
    public Object marshal(Object v) throws Exception {
        Department dep = (Department)v;
        return dep.getDepartmentName();
    }
}
