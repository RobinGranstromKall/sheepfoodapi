package se.nackademin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.nackademin.domain.Ingredient;
import se.nackademin.service.IngredientService;

import java.util.List;

@Controller
public class IngredientController {

    private final IngredientService service;

    @Autowired
    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    private ResponseEntity<List<Ingredient>> getIngredients() {
        List<Ingredient> unitList = service.getIngredients();
        if (unitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(unitList, HttpStatus.OK);
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    private ResponseEntity<HttpStatus> postIngredients(@RequestBody Ingredient ingredient) {
        try {
            service.addIngredient(ingredient);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
