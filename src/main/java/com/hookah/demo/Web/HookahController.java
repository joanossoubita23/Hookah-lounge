package com.hookah.demo.Web;

import com.hookah.demo.entity.Hookah;
import com.hookah.demo.service.HookahService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/v1/hookah")

public class HookahController {
    private final HookahService hookahService;

    public HookahController(HookahService hookahService) {
        this.hookahService = hookahService;


    }
    @GetMapping("/hookahs")
    public ResponseEntity<List<Hookah>> gethookahs(){
        return new ResponseEntity<>(hookahService.gethookahs(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Hookah> gethookahById(@PathVariable Long id){
        return new ResponseEntity<>(hookahService.gethookahById(id),HttpStatus.OK);
    }
}
