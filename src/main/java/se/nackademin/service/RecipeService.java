package se.nackademin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.domain.Recipe;
import se.nackademin.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> getRecipes() {
        return repository.findAll();
    }

    public void addRecipe(Recipe recipe) {
        repository.save(recipe);
    }

    public Recipe getRecipe(Long id) {
        return repository.findOne(id);
    }

    public List<Recipe> search(String searchQuery) {
        return repository.findByDescriptionContainingIgnoreCaseOrTitleContainingIgnoreCase(searchQuery, searchQuery);
    }
}
