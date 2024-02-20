package moblog.bubun.moblogproject.service;

import moblog.bubun.moblogproject.model.Places;

public interface BlogService {

    Object getBlogs();

    void addBlog(Places place);

    void updateBlog(Places place);

    Object updateBlogPage(int id);

    Object getExplore(int id);

    void deleteBlog(int id);
    
}
