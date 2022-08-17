package com.example.netflux.controllers;

import com.example.netflux.domain.Movie;
import com.example.netflux.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable("id") String movieId){
        return movieService.getById(movieId);
    }

    @GetMapping
    public Flux<Movie> getMovies(){
        return movieService.findAll();
    }
}
