package com.prudhvi.ToTW_web.utility;

import com.prudhvi.ToTW_web.domain.Recipe;
import com.prudhvi.ToTW_web.domain.Author;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataGeneratorUtil {

    public static String generateRandomString(int length) {

        StringBuilder value = new StringBuilder();
        if(length >= 1){

            //Generate uppercase letter randomly generate a alphabet using unicode version
            value.append((char) (new Random().nextInt(26) + 65));
        }

        while(length > 1){
            value.append((char) (new Random().nextInt(26) + 97));
            length--;
        }
        return value.toString();
    }

    public static Author generateRandomUser() {

        Author user = new Author();
        user.setFirstName(generateRandomString(new Random().nextInt(10) + 5));
        user.setLastName(generateRandomString(new Random().nextInt(10) + 5));
        user.setUsername(user.getFirstName()+user.getLastName());
        user.setEmail(generateRandomString(new Random().nextInt(20) + 10)+"@mail.com");

        return user;
    }

    public static Recipe generateRandomRecipe() {
        Recipe recipe = new Recipe();
        recipe.setTitle(generateRandomString(new Random().nextInt(10) + 20));
        recipe.setDescription(generateRandomString(new Random().nextInt(20) + 20));
        recipe.setCategory(generateRandomString(new Random().nextInt(5) + 5));
        return recipe;
    }
}
