package com.will.springwebflux.controller;

import com.will.springwebflux.document.Hero;
import com.will.springwebflux.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;


@RestController
public class HeroController {

    @Autowired
    HeroService heroService;

    @PostMapping(value = "/heroes")
    public Mono<Hero> save(@RequestBody Hero hero) {
        return heroService.save(hero);
    }

    @GetMapping(value = "/heroes")
    public Flux<Hero> findAll() {
        return heroService.findAll();
    }

    @GetMapping(value = "/heroes/{id}")
    public Mono<Hero> findById(@PathVariable String id) {
        return heroService.findById(id);
    }

    @GetMapping(value = "/heroes/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Hero>> findAllEvents() {
        Flux<Long> time = Flux.interval(Duration.ofSeconds(15));
        Flux<Hero> events = heroService.findAll();
        System.out.println("Já foi!!!");
        return Flux.zip(time, events);
    }


}
