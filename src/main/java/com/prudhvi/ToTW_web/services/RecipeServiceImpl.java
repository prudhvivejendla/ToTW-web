package com.prudhvi.ToTW_web.services;

import com.prudhvi.ToTW_web.domain.Recipe;
import com.prudhvi.ToTW_web.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Iterable<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
