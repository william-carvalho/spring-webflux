package com.will.springwebflux.config;

import com.will.springwebflux.handler.HeroHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class HeroRouter {

    //@Bean
    public RouterFunction<ServerResponse> route(HeroHandler heroHandler){
        return RouterFunctions
                .route(POST("/heroes").and(accept(MediaType.APPLICATION_JSON)), heroHandler::save)
                .andRoute(GET("/heroes/{id}").and(accept(MediaType.APPLICATION_JSON)), heroHandler::findById)
                .andRoute(GET("/heroes").and(accept(MediaType.APPLICATION_JSON)), heroHandler::findAll);


    }
}
