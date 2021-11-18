package com.will.springwebflux.repository;

import com.will.springwebflux.document.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HeroRepository extends ReactiveMongoRepository<Hero, String> {


}
