package com.prudhvi.ToTW_web.controllers;

import com.prudhvi.ToTW_web.domain.Recipe;
import com.prudhvi.ToTW_web.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Recipe>> getRecipes() {
        Iterable<Recipe> recipes = recipeService.getRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
