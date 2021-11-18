package com.will.springwebflux.service;

import com.will.springwebflux.document.Hero;
import com.will.springwebflux.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroImpl implements HeroService {

    @Autowired
    HeroRepository heroRepository;

    @Override
    public Mono<Hero> update(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Mono<Void> delete(String id) {
        return heroRepository.deleteById(id);
    }

    @Override
    public Mono<Hero> findById(String id) {
        return heroRepository.findById(id);
    }

    @Override
    public Flux<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Mono<Hero> save(Hero hero) {
        return heroRepository.save(hero);
    }
}
