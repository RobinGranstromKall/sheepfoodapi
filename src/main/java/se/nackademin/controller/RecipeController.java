package se.nackademin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.nackademin.domain.Recipe;
import se.nackademin.service.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    private final RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    private ResponseEntity<List<Recipe>> getRecipes(@RequestParam(value = "q", required = false) String searchQuery) {
        List<Recipe> recipeList;

        if (searchQuery == null) {
            recipeList = service.getRecipes();
        } else {
            recipeList = service.search(searchQuery);
        }

        if (recipeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(recipeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    private ResponseEntity<HttpStatus> postRecipe(@RequestBody Recipe recipe) {
        try {
            service.addRecipe(recipe);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    private ResponseEntity<Recipe> getRecipe(@PathVariable("id") long id) {
        Recipe recipe = service.getRecipe(id);

        if (recipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

}
