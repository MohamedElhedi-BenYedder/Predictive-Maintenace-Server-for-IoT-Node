package tn.p2m.springboot.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tn.p2m.springboot.demo.Model.Engine;
import tn.p2m.springboot.demo.Repository.EngineRepository;

import java.util.List;

@Component
public class EngineServiceImpl implements EngineService{
    @Autowired
    EngineRepository engineRepository;

    @Override
    public Engine create(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Engine update(Engine engine) {
        return null;
    }

    @Override
    public List<Engine> getAll() {
        return engineRepository.findAll();
    }

    @Override
    public List<Engine> getById(int id) {
        return engineRepository.findByEngineId(id);
    }

    @Override
    public Engine getByIdAndCycle(int id, int cycle) {
        return engineRepository.findByEngineIdAndCycle(id,cycle);
    }

    @Override
    public int newId() {
        return engineRepository.findAll(Sort.by(Sort.Direction.DESC,"appointmentNumber")).get(0).getEngineId()+1;
    }

    @Override
    public void delete(Engine engine) {
         engineRepository.delete(engine);
    }

    @Override
    public void clearAll() {
        engineRepository.deleteAll();
    }
}
