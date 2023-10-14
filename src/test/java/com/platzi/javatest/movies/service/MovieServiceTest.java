package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private MovieService movieService;
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight",152, Genre.ACTION),
                        new Movie(2, "Memento",113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary",119, Genre.COMEDY),
                        new Movie(4, "Super 8",112, Genre.THRILLER),
                        new Movie(5, "Scream",111, Genre.HORROR),
                        new Movie(6, "Home Alone",103, Genre.COMEDY),
                        new Movie(7, "matrix",136, Genre.ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    void return_movies_by_genre(){
        Collection<Movie> moviesComedy = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getIds(moviesComedy), is(Arrays.asList(3, 6)));
    }

    @Test
    void return_movies_by_length(){
        Collection<Movie> moviesByLength = movieService.findMoviesByLength(120);
        assertThat(getIds(moviesByLength), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    private List<Integer> getIds(final Collection<Movie> moviesByLength) {
        return moviesByLength
                .stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }

//    @beforeMethod
//    void return_movies_by_length(){
//        Collection<Movie> moviesByLength = movieService.findMoviesByLength(120);
//        List<Integer> movieIDsByLength = moviesByLength
//                .stream()
//                .map(Movie::getId)
//                .collect(Collectors.toList());
//        assertThat(movieIDsByLength, is(Arrays.asList(2, 3, 4, 5, 6)));
//    }
}