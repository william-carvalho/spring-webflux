package com.will.springwebflux.handler;

import com.will.springwebflux.document.Hero;
import com.will.springwebflux.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class HeroHandler {

    @Autowired
    HeroService heroService;

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        Mono<Hero> hero = serverRequest.bodyToMono(Hero.class);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(hero.flatMap(heroService::save), Hero.class));
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(heroService.findById(id), Hero.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(heroService.findAll(), Hero.class);
    }
}
