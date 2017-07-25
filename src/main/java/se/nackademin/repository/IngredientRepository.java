package se.nackademin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.nackademin.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
