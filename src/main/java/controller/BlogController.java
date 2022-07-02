package controller;

import domain.Blog;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BlogService;
import util.DateUtil;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

//    @RequestMapping("/all")
//    public String all(Model model) {
//        List<Blog> blogs = blogService.selectAllBlogs();
//        model.addAttribute("blogs", blogs);
//        return "main";
//    }

    @RequestMapping("/add")
    public String add(String content, HttpSession session) {
        User user = (User) session.getAttribute("user");

        Blog blog = new Blog();
        blog.setContent(content);
        blog.setSenderid(user.getId());
        blog.setTime(DateUtil.currentTimestamp());

        String s = blogService.addBlog(blog);
        return s;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        String s = blogService.deleteBlogById(id);
        return s;
    }

    @RequestMapping("/tomain")
    public String toMain(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        System.out.println("session user = " + user);

        List<Blog> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "main";
    }

    @RequestMapping("/toreply")
    public String toReply(Integer id, HttpSession session, Model model) {
        //id: 被回复的blog的id
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "reply";
    }

    @RequestMapping("/reply")
    public String reply(Integer id, String content, HttpSession session) {
        User user = (User) session.getAttribute("user");

        Blog blog = new Blog();
        blog.setSenderid(user.getId());
        blog.setContent(content);
        blog.setTime(new Date().getTime() + "");
        blog.setReplyto(id);

        String s = blogService.addBlog(blog);
        return s;
    }
}
