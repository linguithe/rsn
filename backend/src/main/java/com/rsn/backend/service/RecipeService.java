package com.rsn.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsn.backend.model.Recipe;
import com.rsn.backend.repo.RecipeRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    public Flux<Recipe> findAll() {
        return recipeRepo.findAll();
    }

    public Flux<Recipe> findByTitleContaining(String title) {
        return recipeRepo.findByTitleContaining(title);
    }

    public Mono<Recipe> findById(int id) {
        return recipeRepo.findById(id);
    }

    public Mono<Recipe> save(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public Mono<Recipe> update(int id, Recipe recipe) {
        return recipeRepo.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
            .flatMap(optionalRecipe -> {
                if (optionalRecipe.isPresent()) {
                    recipe.setId(id);
                    return recipeRepo.save(recipe);
                }

                return Mono.empty();
            });
    }

    public Mono<Void> delete(int id) {
        return recipeRepo.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return recipeRepo.deleteAll();
    }
}
