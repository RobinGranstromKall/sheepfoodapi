package se.nackademin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.nackademin.domain.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long>  {
    List<Recipe> findByDescriptionContainingIgnoreCaseOrTitleContainingIgnoreCase(String q1, String q2);
}
