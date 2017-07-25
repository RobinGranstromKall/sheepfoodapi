package se.nackademin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.nackademin.domain.Unit;
import se.nackademin.service.UnitService;

import java.util.List;

@Controller
public class UnitController {

    private final UnitService service;

    @Autowired
    public UnitController(UnitService service) {
        this.service = service;
    }

    @RequestMapping(value = "/units", method = RequestMethod.GET)
    private ResponseEntity<List<Unit>> getUnits() {
        List<Unit> unitList = service.getUnits();
        if (unitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(unitList, HttpStatus.OK);
    }

    @RequestMapping(value = "/units", method = RequestMethod.POST)
    private ResponseEntity<HttpStatus> postUnit(@RequestBody Unit unit) {
        try {
            service.addUnit(unit);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
