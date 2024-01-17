package com.hookah.demo.Web;

import com.hookah.demo.entity.Drinks;
import com.hookah.demo.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/vi/drink")

public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }
    @GetMapping("/drinks")
    public ResponseEntity<List<Drinks>> getdrinks(){
        return  new ResponseEntity<>(drinkService.getdrinks(), HttpStatus.OK);
    }
}
