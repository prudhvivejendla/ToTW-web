package com.prudhvi.ToTW_web.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String category;
    private String image;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "user_recipes", joinColumns =  @JoinColumn(name ="recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Author> authors;

    @ManyToOne (fetch = FetchType.LAZY)
    private Cuisine cuisine;

    public Recipe() {
    }

    public Recipe(Long id, String title, String description, String category, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Recipe addAuthor(Author user) {
        if (authors == null) {
            authors = new HashSet<>();
        }
        authors.add(user);
        return this;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Recipe setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
