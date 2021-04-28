package tn.p2m.springboot.demo.service;

import tn.p2m.springboot.demo.model.Engine;

import java.util.List;

public interface EngineService {
    public Engine create(Engine engine);
    public Engine update(Engine engine);
    public void delete(Engine engine);
    public void clearAll();
    public int newId();
    public List<Engine> getAll();
    public Engine getById(int id);
}
