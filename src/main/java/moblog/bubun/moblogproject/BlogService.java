package moblog.bubun.moblogproject;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final JdbcTemplate jdbcTemplate;

    public void addPlace(Places place) {
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
}
