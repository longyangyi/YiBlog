package controller;

import domain.Blog;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BlogService;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/register")
    public String register(String nickname, String uname, String upwd) {
        System.out.println("register request: " + nickname + ", " + uname + ", " + upwd);
        User user = new User();
        user.setNickname(nickname);
        user.setUname(uname);
        user.setUpwd(upwd);
        String register = userService.register(user);
        return register;
    }

    @RequestMapping("/login")
    public String login(String uname, String upwd, HttpSession session, Model model) {
        System.out.println("login request: " + uname + ", "+ upwd);
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        String login = userService.login(user, session);
        if (login.equals("main")) {
            model.addAttribute("uname", uname);
            List<Blog> blogs = blogService.findAllBlogs();
            model.addAttribute("blogs", blogs);
        }
        return login;
    }

    @RequestMapping("/password")
    public String password(String upwd, HttpSession session) {
        System.out.println("password request: " + upwd);
        User user = (User) session.getAttribute("user");
        user.setUpwd(upwd);
        String password = userService.password(user);
        return password;
    }

    @RequestMapping("/topassword")
    public String toPassword(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "password";
    }

}
