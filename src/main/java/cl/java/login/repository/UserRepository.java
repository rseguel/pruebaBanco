package cl.java.login.repository;

import cl.java.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByNameAndPassword(String name,String password);
    User findByMailAndPassword(String mail,String password);

    User findByName(String name);
    User findByMail(String mail);

}
