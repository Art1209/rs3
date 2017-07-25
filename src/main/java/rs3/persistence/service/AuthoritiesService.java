package rs3.persistence.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs3.persistence.DAO.daoInterf.AuthoritiesDaoInterface;

import java.util.HashSet;
import java.util.Set;

@Log4j
@Service
public class AuthoritiesService {


    @Autowired
    private AuthoritiesDaoInterface authDao;

    @Transactional
    public Set<GrantedAuthority> getRoles(String username){
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role:authDao.getRolesForUser(username)) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        log.info("AuthoritiesService got these roles : " + roles.toString());
        return roles;
    }
}
