package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

class MovieRepositoryJDBCTest {

    private MovieRepositoryJDBC movieRepositoryJDBC;
    private DataSource dataSource;
    @BeforeEach
    void setUp() throws SQLException {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-script/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);
    }

    @Test
    void load_all_movies() {

        Collection<Movie> movies = movieRepositoryJDBC.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION),
                new Movie(4, "Memo", 134, Genre.DRAMA)
        )));
    }

    @Test
    void load_movie_by_id() {
        Movie byId = movieRepositoryJDBC.findById(2);
        assertThat(byId, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    void insert_a_new_movie(){
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

        movieRepositoryJDBC.saveOrUpdate(movie);

        Movie movieFromDb = movieRepositoryJDBC.findById(5);

        assertThat(movieFromDb, is(new Movie(5, "Super 8", 112, Genre.THRILLER)));
    }

    @Test
    void search_movie_for_name(){
        Collection<Movie> movie = movieRepositoryJDBC.findByName("Mem");
        assertThat(movie, is(Arrays.asList(new Movie(2, "Memento", 113, Genre.THRILLER),
                                            new Movie(4, "Memo", 134, Genre.DRAMA))));
    }

    @AfterEach
    public void tearDown() throws SQLException{
        // Remove H2 files --- https://stackoverflow.com/a/51809831/1121487
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem deb
    }

}