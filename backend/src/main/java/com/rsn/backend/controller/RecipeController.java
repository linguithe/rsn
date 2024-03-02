package com.rsn.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsn.backend.model.Recipe;
import com.rsn.backend.repo.RecipeRepo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    RecipeRepo recipeRepo;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(@RequestParam(required = false) String title) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        if (title == null) {
            recipeRepo.findAll().forEach(recipes::add);
        } else {
            recipeRepo.findByTitle(title).forEach(recipes::add);
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") long id) {
        Recipe recipe = recipeRepo.findById(id).get();
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("recipes/{ingredient}")
    public ResponseEntity<List<Recipe>> getRecipesByIngredient(@PathVariable("ingredient") String ingredient) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        recipeRepo.findByIngredients(ingredient).forEach(recipes::add);
        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") long id, @RequestBody Recipe recipe) {
        
    }

    @DeleteMapping("/recipes")
    public ResponseEntity<HttpStatus> deleteAllRecipes() {
        
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") long id) {
        
    }
       
}
