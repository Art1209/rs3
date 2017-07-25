package rs3.persistence.service.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import rs3.persistence.DAO.daoImpl.repository.UserRepository;
import rs3.persistence.DAO.daoInterf.UserDaoInterface;
import rs3.persistence.entity.User;

import java.util.List;

//@Service
public class UserServiceImpl //implements UserService
{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDaoInterface userDao;

//    @Override
    public User addUser(User user) {
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

//    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

//    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

//    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

//    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

//    @Override
    public User getUser(String login) {
        return userDao.getUserByLogin(login);
    }
}