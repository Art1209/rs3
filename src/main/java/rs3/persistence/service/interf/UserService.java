package rs3.persistence.service.interf;

import rs3.persistence.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getByName(String name);
    User editUser(User user);
    List<User> getAll();
}
