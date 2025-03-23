package com.prudhvi.ToTW_web.bootstrap;

import com.prudhvi.ToTW_web.domain.Author;
import com.prudhvi.ToTW_web.domain.Cuisine;
import com.prudhvi.ToTW_web.domain.Recipe;
import com.prudhvi.ToTW_web.repositories.CuisineRepository;
import com.prudhvi.ToTW_web.repositories.RecipeRepository;
import com.prudhvi.ToTW_web.repositories.UserRepository;
import com.prudhvi.ToTW_web.utilities.DataGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BootStartData implements CommandLineRunner {

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(String... args) {

        int numberOfUsers = new Random().nextInt(5) + 6;
        List<Author> users = new ArrayList<>();
        while (numberOfUsers > 0) {
            users.add(DataGeneratorUtil.generateRandomUser());
            numberOfUsers--;
        }
        userRepository.saveAll(users);

        int numberOfCuisines = new Random().nextInt(5) + 6;
        List<Cuisine> cuisines = new ArrayList<>();
        while (numberOfCuisines > 0) {
            cuisines.add(DataGeneratorUtil.generateRandomCuisine());
            numberOfCuisines--;
        }
        cuisineRepository.saveAll(cuisines);

        int numberOfRecipes = new Random().nextInt(20) + 10;
        List<Recipe> recipes = new ArrayList<>();
        while (numberOfRecipes > 0) {
            recipes.add(DataGeneratorUtil.generateRandomRecipe()
                    .addAuthor(users.get(new Random().nextInt(users.size())))
                    .setCuisine(cuisines.get(new Random().nextInt(cuisines.size()))));
            numberOfRecipes--;
        }
        recipeRepository.saveAll(recipes);

        System.out.println("Number of users: " + userRepository.count());
        System.out.println("Number of recipes: " + recipeRepository.count());
        System.out.println("Number of cuisines: " + cuisineRepository.count());
    }
}
