package service;

import domain.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    public String register(User user);
    public String login(User user, HttpSession session);
    public String password(User user);
    public User findUserByUname(String uname);

}
