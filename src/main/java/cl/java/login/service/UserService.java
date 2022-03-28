package cl.java.login.service;

import cl.java.login.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User crear(User employee);

    User getById(int id);
}
