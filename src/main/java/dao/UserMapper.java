package dao;

import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public Integer register(User user);
    public List<User> login(User user);
    public Integer password(User user);
    public List<User> findUserByUname(String uname);
    public List<User> findUserById(Integer id);

}
