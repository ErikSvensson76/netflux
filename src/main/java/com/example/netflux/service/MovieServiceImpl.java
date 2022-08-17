package com.example.netflux.service;

import com.example.netflux.domain.Movie;
import com.example.netflux.domain.MovieEvent;
import com.example.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> getById(final String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvents(final String id) {
        return Flux.<MovieEvent>generate(generator -> generator.next(new MovieEvent(id, LocalDateTime.now())))
                .delayElements(Duration.ofSeconds(1));
    }
}
