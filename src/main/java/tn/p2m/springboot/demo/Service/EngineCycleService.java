package tn.p2m.springboot.demo.Service;

import tn.p2m.springboot.demo.Model.EngineCycle;

import java.util.List;

public interface EngineCycleService {
    public EngineCycle create(EngineCycle engineCycle);
    public EngineCycle update(EngineCycle engineCycle);
    public void delete(EngineCycle engineCycle);
    public void clearAll();
    public int newId();
    public List<EngineCycle> getAll();
    public List<EngineCycle> getById(int id);
    public EngineCycle getByIdAndCycle(int id , int cycle);


}
