package rs3.persistence.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs3.persistence.entity.User;
import rs3.persistence.service.serviceInterf.UserService;

@Log4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;
    @Autowired
    private AuthoritiesService authoritiesService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUser(username);
        log.info(user.getLogin()+user.getPassword()+authoritiesService.getRoles(username));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),authoritiesService.getRoles(username));
        return userDetails;
    }
}
