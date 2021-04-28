package tn.p2m.springboot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.p2m.springboot.demo.model.Engine;
import tn.p2m.springboot.demo.model.EngineCycle;
import tn.p2m.springboot.demo.service.EngineCycleServiceImpl;
import tn.p2m.springboot.demo.util.body.AddMeasurementRequestBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/engineCycle")
public class EngineCycleController {
    @Autowired
    EngineCycleServiceImpl engineCycleService;
    @GetMapping("/getAll")
    public List<EngineCycle> getAll(){
        return engineCycleService.getAll();
    }
    /*@GetMapping("/getAllByEngine")
    public List<EngineCycle> getAllByEngine(@RequestBody Engine engine){
        return engineCycleService.getAllByEngine(engine);
    }
    @GetMapping("/getByEngineAndCycle/{cycle}")
    public EngineCycle getByEngineAndCycle(@RequestBody Engine engine, @PathVariable("cycle") int cycle){
        return engineCycleService.getByEngineAndCycle(engine,cycle);
    }

     */
    @PostMapping("/create")
    public EngineCycle create(@RequestBody EngineCycle engineCycle){
        return engineCycleService.create(engineCycle);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody EngineCycle engineCycle){
        engineCycleService.delete(engineCycle);
    }
    @DeleteMapping("/clearAll")
    public void clearAll(){
        engineCycleService.clearAll();
    }

    @PostMapping("/addMeasurement")
    public EngineCycle addMeasurement(@RequestBody AddMeasurementRequestBody body)
    {
        return engineCycleService.addMeasurement(body.engineCycle,body.measurements);
    }
    @GetMapping("/updateModel")
    public  String updateModel() throws IOException {

        long startTime = new Date().getTime();
        Process process = Runtime.getRuntime().exec("runipy C:\\Users\\MHBY1\\OneDrive\\Documents\\P2M\\Work\\Data_Wrangling.ipynb");
        String loading ="";
        int counter =0;
        while(process.isAlive() && counter < 100000)
        {
            counter++;
        }
        long endTime = new Date().getTime();
        double diff = (endTime-startTime)/1000.0;
        int diff_min = (int) (diff /60);
        int diff_sec = (int) (diff-diff_min*60);
        int diff_ms = (int) ((diff - diff_sec - diff_min*60 )*1000);
        return "Data Wrangling Takes "+ diff_min+" mn: "+diff_sec +" s: "+diff_ms+" ms ~ "+counter+" iter";
    }
}
