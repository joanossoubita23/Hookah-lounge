package com.hookah.demo.Web;

import com.hookah.demo.entity.Hookah;
import com.hookah.demo.service.HookahService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping("/add")
    public ResponseEntity<Hookah> addhookah(@RequestBody Hookah hookah){
        return new ResponseEntity<>(hookahService.addhookah(hookah),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Hookah>deleteHookahById(@PathVariable Long id){
        hookahService.gethookahById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hookah> updateHookahById(@PathVariable Long id,@RequestBody Hookah hookah){
        return new ResponseEntity<>(hookahService.updateHookahById(id,hookah),HttpStatus.CREATED);

    }
}
