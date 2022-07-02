package service;

import domain.Blog;

import java.util.List;

public interface BlogService {

    public String addBlog(Blog blog);
    public String deleteBlogById(Integer id);
    public List<Blog> findAllBlogs();
    public Blog findBlogById(Integer id);

}
