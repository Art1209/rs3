package rs3.persistence.DAO.daoInterf;


import java.util.List;


public interface AuthoritiesDaoInterface {
    List<String> getRolesForUser(String username);
}
