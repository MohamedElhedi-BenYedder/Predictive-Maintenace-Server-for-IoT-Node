package tn.p2m.springboot.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.p2m.springboot.demo.Model.Engine;
import tn.p2m.springboot.demo.Service.EngineServiceImpl;

import java.io.IOException;
import java.util.List;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/drillingMachineEngine")
public class EngineController {
    @Autowired
    EngineServiceImpl engineService;
    @GetMapping("/getAll")
    public List<Engine> getAll(){
        return engineService.getAll();
    }
    @GetMapping("/getAll/{id}")
    public List<Engine> getById(@PathVariable int id){
        return engineService.getById(id);
    }
    @GetMapping("/getAll/{id}/{cycle}")
    public Engine getByIdAndCycle(@PathVariable("id") int id,@PathVariable("cycle") int cycle){
        return engineService.getByIdAndCycle(id,cycle);
    }
    @PostMapping("/create")
    public Engine create(@RequestBody Engine engine){
        return engineService.create(engine);
    }
    @GetMapping("/newId")
    public int newId(){
        return engineService.newId();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Engine engine){
        engineService.delete(engine);
    }
    @DeleteMapping("/clearAll")
    public void clearAll(){
        engineService.clearAll();
    }
    @GetMapping("/updateModel")
    public void updateModel() throws IOException {
        Process p = Runtime.getRuntime().exec("runipy C:\\Users\\MHBY1\\OneDrive\\Documents\\P2M\\Work\\Data_Wrangling.ipynb");

    }
}
