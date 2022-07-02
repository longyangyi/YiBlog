package dao;

import domain.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    public Integer addBlog(Blog blog);
    public Integer deleteBlogById(Integer id);
    public List<Blog> findAllBlogs();
    public List<Blog> findBlogById(Integer id);

}
