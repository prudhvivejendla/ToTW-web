package com.prudhvi.ToTW_web.repositories;

import com.prudhvi.ToTW_web.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
