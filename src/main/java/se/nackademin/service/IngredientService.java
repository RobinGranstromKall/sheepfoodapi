package se.nackademin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.domain.Ingredient;
import se.nackademin.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public List<Ingredient> getIngredients() {
        return repository.findAll();
    }

    public void addIngredient(Ingredient ingredient) {
        repository.save(ingredient);
    }

}
