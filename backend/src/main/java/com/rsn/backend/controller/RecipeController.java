package com.rsn.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.rsn.backend.service.RecipeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.rsn.backend.model.Recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Recipe> getAllRecipes(@RequestParam(required = false) String title) {
        if (title == null) {
            return recipeService.findAll();
        } else {
            return recipeService.findByTitleContaining(title);
        }
    }

    @GetMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Recipe> getRecipeById(@PathVariable int id) {
        return recipeService.findById(id);
    }

    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recipe> createRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @PostMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeService.update(id, recipe);
    }

    @PostMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRecipe(@PathVariable int id) {
        return recipeService.delete(id);
    }

    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllRecipes() {
        return recipeService.deleteAll();
    }
}