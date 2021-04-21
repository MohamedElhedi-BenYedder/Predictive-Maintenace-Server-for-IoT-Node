package tn.p2m.springboot.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.p2m.springboot.demo.Model.EngineCycle;
import tn.p2m.springboot.demo.Service.EngineCycleServiceImpl;

import java.io.IOException;
import java.util.List;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/drillingMachineEngine")
public class EngineCycleController {
    @Autowired
    EngineCycleServiceImpl engineCycleService;
    @GetMapping("/getAll")
    public List<EngineCycle> getAll(){
        return engineCycleService.getAll();
    }
    @GetMapping("/getAll/{id}")
    public List<EngineCycle> getById(@PathVariable int id){
        return engineCycleService.getById(id);
    }
    @GetMapping("/getAll/{id}/{cycle}")
    public EngineCycle getByIdAndCycle(@PathVariable("id") int id, @PathVariable("cycle") int cycle){
        return engineCycleService.getByIdAndCycle(id,cycle);
    }
    @PostMapping("/create")
    public EngineCycle create(@RequestBody EngineCycle engineCycle){
        return engineCycleService.create(engineCycle);
    }
    @GetMapping("/newId")
    public int newId(){
        return engineCycleService.newId();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody EngineCycle engineCycle){
        engineCycleService.delete(engineCycle);
    }
    @DeleteMapping("/clearAll")
    public void clearAll(){
        engineCycleService.clearAll();
    }
    @GetMapping("/updateModel")
    public void updateModel() throws IOException {
        Process p = Runtime.getRuntime().exec("runipy C:\\Users\\MHBY1\\OneDrive\\Documents\\P2M\\Work\\Data_Wrangling.ipynb");

    }
}
