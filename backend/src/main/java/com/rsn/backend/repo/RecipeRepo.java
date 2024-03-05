package com.rsn.backend.repo;

import java.util.List;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.rsn.backend.model.Recipe;

import reactor.core.publisher.Flux;

@Repository
public interface RecipeRepo extends R2dbcRepository<Recipe, Integer> {
    Flux<Recipe> findByTitleContaining(String title);
}