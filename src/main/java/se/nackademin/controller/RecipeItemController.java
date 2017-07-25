package se.nackademin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.nackademin.domain.RecipeItem;
import se.nackademin.service.RecipeItemService;

import java.util.List;

@Controller
public class RecipeItemController {

    private final RecipeItemService service;

    @Autowired
    public RecipeItemController(RecipeItemService service) {
        this.service = service;
    }

    @RequestMapping(value = "/recipe-items", method = RequestMethod.GET)
    private ResponseEntity<List<RecipeItem>> getRecipeItems() {
        List<RecipeItem> recipeList = service.getRecipeItems();
        if (recipeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(recipeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/recipe-items", method = RequestMethod.POST)
    private ResponseEntity<HttpStatus> postRecipeItem(@RequestBody RecipeItem recipeItem) {
        try {
            service.addRecipeItem(recipeItem);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/recipe-items/{id}", method = RequestMethod.GET)
    private ResponseEntity<RecipeItem> getRecipeItem(@PathVariable("id") long id) {
        RecipeItem recipeItem = service.getRecipeItem(id);

        if (recipeItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(recipeItem, HttpStatus.OK);
    }

}
