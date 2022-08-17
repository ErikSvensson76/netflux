package com.example.netflux.service;

import com.example.netflux.domain.Movie;
import com.example.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> getById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }
}