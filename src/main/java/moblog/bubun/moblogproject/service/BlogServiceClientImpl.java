package moblog.bubun.moblogproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import moblog.bubun.moblogproject.model.Places;

@Service
@RequiredArgsConstructor
public class BlogServiceClientImpl implements BlogService{

    private final JdbcClient jdbcClient;

    @Value("${prefix}")
    private String prefix;
    @Override
    public void addBlog(Places place) {  
        var heading = prefix + " " + place.getHeading();
        var description = place.getDescription();
        String sql = "INSERT INTO moblog (heading, description) VALUES(:h, :d)";
        jdbcClient.sql(sql)
        .params(Map.of("h",heading, "d",description))
        .update();
    }

    @Override
    public void deleteBlog(int id) {
    }

    @Override
    public List<Places> getBlogs() {
        String sql = "SELECT * FROM moblog";
        return jdbcClient.sql(sql).query(Places.class).list();
    }

    @Override
    public Object getExplore(int id) {
        String sql = "SELECT * FROM moblog WHERE id = :i";
        var optional = jdbcClient.sql(sql)
        .param("i",id)
        .query(Places.class)
        .optional();
        return optional.orElseThrow();
    }

    @Override
    public void updateBlog(Places place) {
    }

    @Override
    public Object updateBlogPage(int id) {
        return null;
    }
    
}
