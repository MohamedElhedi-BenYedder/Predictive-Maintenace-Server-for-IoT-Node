package tn.p2m.springboot.demo.service;

import tn.p2m.springboot.demo.model.Engine;
import tn.p2m.springboot.demo.model.EngineCycle;
import tn.p2m.springboot.demo.util.Sensors;

import java.util.List;

public interface EngineCycleService {
    public EngineCycle create(EngineCycle engineCycle);
    public EngineCycle update(EngineCycle engineCycle);
    public EngineCycle addMeasurement(EngineCycle engineCycle ,List<Sensors> measurements);
    public void delete(EngineCycle engineCycle);
    //public void deleteAllByEngine(Engine engine);
    public void clearAll();
    public List<EngineCycle> getAll();
    //public List<EngineCycle> getAllByEngine(Engine engine);
    //public EngineCycle getByEngineAndCycle(Engine engine , int cycle);


}
