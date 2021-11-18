package com.will.springwebflux.service;

import com.will.springwebflux.document.Hero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HeroService {

    Mono<Hero> findById(String id);
    Flux<Hero> findAll();
    Mono<Hero> save(Hero hero);
    Mono<Hero> update(Hero hero);
    Mono<Void> delete(String id);


}
