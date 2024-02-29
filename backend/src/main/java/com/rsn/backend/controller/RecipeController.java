package com.rsn.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.rsn.backend.model.Recipe;
import com.rsn.backend.repo.RecipeRepo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
       
}
