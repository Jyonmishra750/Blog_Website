package moblog.bubun.moblogproject;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final JdbcTemplate jdbcTemplate;

    public void addBlog(Places place) {
        String sql = "INSERT INTO moblog (heading, description) VALUES(?, ?)";
        jdbcTemplate.update(sql, place.getHeading(), place.getDescription());
    }

    public List<Places> getBlogs() {
        String sql = "SELECT * FROM moblog";
        RowMapper<Places> rowMapper = (resultSet, rowNum) -> new Places(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getString("description"));
        return jdbcTemplate.query(sql, rowMapper);

        // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Places>());
    }

    public Places getExplore(int index) {
        String sql = "SELECT * FROM moblog WHERE id =?";
        RowMapper<Places> rowMapper = (resultSet, rowNum) -> new Places(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getString("description"));
        return jdbcTemplate.queryForObject(sql, rowMapper, index);
    }

    public Places updateBlogPage(int id) {
        String sql = "SELECT * FROM moblog WHERE id =?";
        RowMapper<Places> rowMapper = (resultSet, rowNum) -> new Places(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getString("description"));
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void updateBlog(Places place) {
        String sql = "UPDATE moblog SET heading=?, description=? WHERE id=?";
        jdbcTemplate.update(sql, place.getHeading(), place.getDescription(), place.getId());
    }

    public void deleteBlog(int blogid) {
        String sql = "DELETE FROM moblog WHERE id =?";
        jdbcTemplate.update(sql, blogid);
    }

}
