package rs3.persistence.DAO.daoImpl.dao;

import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs3.persistence.DAO.daoInterf.UserDaoInterface;
import rs3.persistence.entity.User;

import java.util.List;

@Log4j
@Repository
public class UserDao implements UserDaoInterface{

    private SessionFactory sessionFactory;
//    private Logger log = Logger.getLogger(UserDao.class);

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public User getUserByLogin(String login) {
//        List<User> users = getAll();
//        for (User user:users){
//            log.debug(user.getLogin()+"=="+login);
//            if (user.getLogin().equals(login)) return user;
//            log.debug(true);
//        }
//        return null;
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Long(1));
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        log.debug("trying get all users");
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createQuery("from User").list();
        log.debug(usersList.toString());
        return usersList;
    }
}
