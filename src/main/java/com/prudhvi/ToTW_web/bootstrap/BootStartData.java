package com.prudhvi.ToTW_web.bootstrap;

import com.prudhvi.ToTW_web.domain.Author;
import com.prudhvi.ToTW_web.domain.Recipe;
import com.prudhvi.ToTW_web.repository.RecipeRepository;
import com.prudhvi.ToTW_web.repository.UserRepository;
import com.prudhvi.ToTW_web.utility.DataGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BootStartData implements CommandLineRunner {

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

        int numberOfRecipes = new Random().nextInt(20) + 10;
        List<Recipe> recipes = new ArrayList<>();
        while (numberOfRecipes > 0) {
            recipes.add(DataGeneratorUtil.generateRandomRecipe().addAuthor(users.get(new Random().nextInt(users.size()))));
            numberOfRecipes--;
        }
        recipeRepository.saveAll(recipes);

        System.out.println("Number of users: " + userRepository.count());
        System.out.println("Number of recipes: " + recipeRepository.count());
    }
}
