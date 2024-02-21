package moblog.bubun.moblogproject.service;

import java.util.List;

import moblog.bubun.moblogproject.model.Places;

public interface BlogService {

    List<Places> getBlogs();

    void addBlog(Places place);

    void updateBlog(Places place);

    Object updateBlogPage(int id);

    Object getExplore(int id);

    void deleteBlog(int id);
    
}
