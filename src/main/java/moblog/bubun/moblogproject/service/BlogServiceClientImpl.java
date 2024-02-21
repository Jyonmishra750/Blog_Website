package moblog.bubun.moblogproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import moblog.bubun.moblogproject.model.Places;

@Service
@RequiredArgsConstructor
public class BlogServiceClientImpl implements BlogService{

    private final JdbcClient jdbcClient;

    // @Value("${prefix}")
    // private String prefix;

    @Override
    public void addBlog(Places place) {  
        var heading = place.getHeading();
        var description = place.getDescription();
        String sql = "INSERT INTO moblog (heading, description) VALUES(:h, :d)";
        jdbcClient.sql(sql)
        .params(Map.of("h",heading, "d",description))
        .update();
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
    public Object updateBlogPage(int id) {
        String sql = "SELECT * FROM moblog WHERE id = :i";
        return jdbcClient.sql(sql)
        .param("i",id)
        .query(Places.class);
    }

    @Override
    public void updateBlog(Places place) {
        var id = place.getId();
        var heading = place.getHeading();
        var description = place.getDescription();
        String sql = "UPDATE moblog SET heading = :h, description = :d WHERE id = :i";
        jdbcClient.sql(sql)
        .param("i",id)
        .param("h", heading)
        .param("d",description)
        .update();
    }
    
    @Override
    public void deleteBlog(int id) {
        String sql = "DELETE FROM moblog WHERE id = :i";
        jdbcClient.sql(sql)
        .param("i",id)
        .update();
    }
}
