package cl.java.login.service;

import cl.java.login.mapper.UserDetailsMapper;
import cl.java.login.model.User;
import cl.java.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User crear(User user){
        user.setCreated(new Date(new java.util.Date().getTime()));
        user.setModified(new Date(new java.util.Date().getTime()));

        return userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final User retrievedUser = userRepository.findByMail(userName);
        if (retrievedUser == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return UserDetailsMapper.build(retrievedUser);
    }

}
