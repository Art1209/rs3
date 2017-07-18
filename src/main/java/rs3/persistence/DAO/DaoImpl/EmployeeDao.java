package rs3.persistence.DAO.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs3.persistence.DAO.DaoInterf.EmployeeDaoInterface;
import rs3.persistence.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeDaoInterface {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public void addEmployee(Employee emp) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(emp);
    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee emp = (Employee) session.load(Employee.class, new Integer(id));
        if(null != emp){
            session.delete(emp);
        }

    }

    @Override
    public void updateEmployee(Employee emp) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(emp);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> depsList = session.createQuery("from Employee").list();
        return depsList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee dep = (Employee) session.load(Employee.class, new Integer(id));
        return dep;
    }
}
