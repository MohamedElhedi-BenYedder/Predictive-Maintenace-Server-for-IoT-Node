package tn.p2m.springboot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.p2m.springboot.demo.model.Engine;
import tn.p2m.springboot.demo.service.EngineServiceImpl;

import java.util.List;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/engine")
public class EngineController {
    @Autowired
    EngineServiceImpl engineService;
    @GetMapping("/getAll")
    public List<Engine> getAll(){
        return engineService.getAll();
    }
    @GetMapping("/getAll/{id}")
    public Engine getById(@PathVariable int id){
        return engineService.getById(id);
    }
    @PostMapping("/create")
    public Engine create(@RequestBody Engine engineCycle){
        return engineService.create(engineCycle);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Engine engineCycle){
        engineService.delete(engineCycle);
    }
    @DeleteMapping("/clearAll")
    public void clearAll(){
        engineService.clearAll();
    }
    @GetMapping("/newId")
    public int newId()
    {
        return engineService.newId();
    }
}
