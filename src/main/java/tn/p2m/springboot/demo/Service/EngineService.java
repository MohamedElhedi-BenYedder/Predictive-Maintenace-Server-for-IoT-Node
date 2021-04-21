package tn.p2m.springboot.demo.Service;

import tn.p2m.springboot.demo.Model.Engine;

import java.util.List;

public interface EngineService {
    public Engine create(Engine engine);
    public Engine update(Engine engine);
    public void delete(Engine engine);
    public void clearAll();
    public int newId();
    public List<Engine> getAll();
    public List<Engine> getById(int id);
    public Engine getByIdAndCycle(int id , int cycle);


}
