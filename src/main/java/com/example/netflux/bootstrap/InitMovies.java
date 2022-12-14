package com.example.netflux.bootstrap;

import com.example.netflux.domain.Movie;
import com.example.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just(
                        "Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator", "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes"
                )).map(title -> Movie.builder().title(title).build())
                .flatMap(movieRepository::save)
                .subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
