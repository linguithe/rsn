package com.rsn.backend.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    // @ElementCollection
    // @Column(name = "ingredients") // makes a new table that has a foreign key to the recipe table
    // private List<String> ingredients;

    // @ElementCollection
    // @OrderColumn(name = "index") // orders the steps
    // @Column(name = "steps")
    // private List<String> steps;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + id + ", title=" + title + "]";
    }
}
