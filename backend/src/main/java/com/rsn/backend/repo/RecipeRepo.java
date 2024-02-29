package com.rsn.backend.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rsn.backend.model.Recipe;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitle(String title);
    List<Recipe> findByIngredients(String ingredient);
    List<Recipe> findBySteps(String step);
}