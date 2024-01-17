package com.hookah.demo.Web;

import com.hookah.demo.entity.Drinks;
import com.hookah.demo.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/drink")

public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }
    @GetMapping("/drinks")
    public ResponseEntity<List<Drinks>> getdrinks(){
        return  new ResponseEntity<>(drinkService.getdrinks(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Drinks> getDrinksById(@PathVariable Long id){
        return new ResponseEntity<>(drinkService.getDrinksById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Drinks> addDrink(@RequestBody Drinks drinks){
        return new ResponseEntity<>(drinkService.addDrink(drinks),HttpStatus.CREATED);
    }
}
