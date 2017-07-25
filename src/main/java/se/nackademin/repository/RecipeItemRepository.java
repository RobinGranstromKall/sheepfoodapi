package se.nackademin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.nackademin.domain.Recipe;
import se.nackademin.domain.RecipeItem;

public interface RecipeItemRepository extends JpaRepository<RecipeItem, Long>  {
}
