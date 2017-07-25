package rs3.persistence.service.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs3.persistence.DAO.daoInterf.UserDaoInterface;
import rs3.persistence.entity.User;
import rs3.persistence.service.serviceInterf.UserService;


@Service
public class UserDaoService implements UserService{

    private UserDaoInterface userDAO;

    @Autowired(required = true)
    public void setUserDAO(UserDaoInterface userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public User getUser(String login) {
        User user = this.userDAO.getUserByLogin(login);
        return user;
    }
}
