package se.nackademin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.domain.Recipe;
import se.nackademin.domain.RecipeItem;
import se.nackademin.repository.RecipeItemRepository;
import se.nackademin.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeItemService {

    private final RecipeItemRepository repository;

    @Autowired
    public RecipeItemService(RecipeItemRepository repository) {
        this.repository = repository;
    }

    public List<RecipeItem> getRecipeItems() {
        return repository.findAll();
    }

    public void addRecipeItem(RecipeItem recipeItem) {
        repository.save(recipeItem);
    }

    public RecipeItem getRecipeItem(Long id) {
        return repository.findOne(id);
    }
}
