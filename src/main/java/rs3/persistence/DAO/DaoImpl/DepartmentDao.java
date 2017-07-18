package rs3.persistence.DAO.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs3.persistence.DAO.DaoInterf.DepartmentDaoInterface;
import rs3.persistence.entity.Department;

import java.util.List;

@Repository
public class DepartmentDao implements DepartmentDaoInterface {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public void addDepartment(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dep);

    }

    @Override
    public void removeDepartment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department dep = (Department) session.load(Department.class, new Integer(id));
        if(null != dep){
            session.delete(dep);
        }

    }

    @Override
    public void updateDepartment(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dep);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Department> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> depsList = session.createQuery("from Department").list();
        return depsList;
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department dep = (Department) session.load(Department.class, new Integer(id));
        return dep;
    }
}
