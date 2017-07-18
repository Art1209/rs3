package rs3.persistence.DAO.DaoInterf;

import rs3.persistence.entity.User;

import java.util.List;

public interface UserDaoInterface {
    void addUser();
    void removeUser();
    void updateUser();
    List<User> getAll();
    User getUserById();
}
