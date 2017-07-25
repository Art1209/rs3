package rs3.persistence.DAO.daoImpl.dao;


import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs3.persistence.DAO.daoInterf.AuthoritiesDaoInterface;
import rs3.persistence.entity.Role;

import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class AuthoritiesDao implements AuthoritiesDaoInterface{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public List<String> getRolesForUser(String username) {
        List<String> rolesAsStringList = new ArrayList<>();
        log.info("trying get roles in authdao for "+ username);
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> rolesList = session.createQuery("from Role").list();
        log.info("roleslist "+rolesList.toString());
        for (Role role:rolesList) {
            log.info(role.getUser().getLogin());
            if (role.getUser().getLogin().equals(username)){
                rolesAsStringList.add(role.getRole());
            }
        }
        log.info("roles"+rolesAsStringList.toString());
        return rolesAsStringList;
    }
}
