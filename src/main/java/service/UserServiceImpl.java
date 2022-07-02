package service;

import dao.UserMapper;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String register(User user) {
        Integer register = userMapper.register(user);
        if (register > 0) {
            System.out.println("register success: " + user.toString());
            return "login";
        } else {
            System.out.println("register error: " + user.toString());
            return "error";
        }
    }

    @Override
    public String login(User user, HttpSession session) {

        List<User> login = userMapper.login(user);
        if (login.size() > 0) {
            System.out.println("login success: " + user.toString());
            session.setAttribute("user", login.get(0));
            System.out.println("session.getAttribute(\"user\") = " + session.getAttribute("user"));
            return "redirect:/blog/tomain";
        } else {
            System.out.println("login error: " + user.toString());
            return "error";
        }
    }

    @Override
    public String password(User user) {
        Integer password = userMapper.password(user);
        if (password > 0) {
            System.out.println("password success: " + user.toString());
            return "login";
        } else {
            return "main";
        }
    }

    @Override
    public User findUserByUname(String uname) {
        return userMapper.findUserByUname(uname).get(0);
    }
}
