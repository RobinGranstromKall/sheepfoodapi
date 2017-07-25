package se.nackademin.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private long id;
    @Basic
    @Column
    private String title;
    @Basic
    @Column
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RecipeItem> recipeItems;
    @Basic
    @Column
    private String imageUrl;

    public Recipe() {
    }

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
