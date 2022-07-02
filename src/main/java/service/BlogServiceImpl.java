package service;

import dao.BlogMapper;
import dao.UserMapper;
import domain.Blog;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public String addBlog(Blog blog) {
        Integer integer = blogMapper.addBlog(blog);
        if (integer > 0) {
            System.out.println("addBlog success: " + blog.toString());
            return "redirect:/blog/tomain";
        } else {
            System.out.println("addBlog error: " + blog.toString());
            return "error";
        }
    }

    @Override
    public String deleteBlogById(Integer id) {
        Integer integer = blogMapper.deleteBlogById(id);
        if (integer > 0) {
            return "redirect:/blog/tomain";
        } else {
            return "error";
        }
    }

    @Override
    public List<Blog> findAllBlogs() { //这里应该改成级联查询
        List<Blog> blogs = blogMapper.findAllBlogs();
        for (Blog blog : blogs) {
            User user = userMapper.findUserById(blog.getSenderid()).get(0);
            blog.setSenderNickname(user.getNickname());

            if(blog.getReplyto() != null) {
                //找到被回复的博客，提取它的senderid
                Blog repliedBlog = blogMapper.findBlogById(blog.getReplyto()).get(0);
                Integer senderid = repliedBlog.getSenderid();
                //根据senderid去找sender的nickname
                User sender = userMapper.findUserById(senderid).get(0);
                String nickname = sender.getNickname();
                blog.setReceiverNickname(nickname);
            }
            blog.setTime(DateUtil.timestampToDate(blog.getTime()));
        }
        return blogs;
    }

    @Override
    public Blog findBlogById(Integer id) {
        Blog blog = blogMapper.findBlogById(id).get(0);
        blog.setTime(DateUtil.timestampToDate(blog.getTime()));

        User user = userMapper.findUserById(blog.getSenderid()).get(0);
        blog.setSenderNickname(user.getNickname());
        return blog;
    }
}
