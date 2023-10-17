package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryJDBC implements MovieRepository {

    JdbcTemplate jdbcTemplate;
    public MovieRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id = ?", movieMapper, args);
    }
    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }
    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString());
    }

    //private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("minutes"),
                Genre.valueOf(rs.getString("genre")));

    public Collection<Movie> findByName(String name) {
        String arg = "%" + name.toLowerCase() + "%";
        return jdbcTemplate.query("select * from movies where LOWER(name) like ?", movieMapper, arg);
    }
}
