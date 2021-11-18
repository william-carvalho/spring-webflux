package com.will.springwebflux;

import com.will.springwebflux.document.Hero;
import com.will.springwebflux.repository.HeroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class FictitiousData implements CommandLineRunner {

    private final HeroRepository heroRepository;

    public FictitiousData(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //A primeira maneira de fazer isso é com um Flux . É um fluxo que pode emitir elementos 0..n .
        heroRepository.deleteAll()
                .thenMany(
                        Flux.just("Captain America", "War Machine", "Spider-Man" ,"Hulk", "Iron Man", "Black Panthe", "Thor", "Vision" ,"Superman","Batman", "Flash")
                                .map(name -> new Hero(UUID.randomUUID().toString(), name))
                                .flatMap(heroRepository::save))
                                .subscribe(System.out::println);

    }
}
