package tn.p2m.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tn.p2m.springboot.demo.model.Engine;
import tn.p2m.springboot.demo.repository.EngineRepository;

import java.util.List;
@Component
public class EngineServiceImpl implements EngineService{
    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Engine create(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Engine update(Engine engine) {
        return null;
    }

    @Override
    public void delete(Engine engine) {
        engineRepository.delete(engine);

    }

    @Override
    public void clearAll() {
        engineRepository.deleteAll();
    }

    @Override
    public int newId() {
        return engineRepository.findAll(Sort.by(Sort.Direction.DESC,"engineId")).get(0).getId()+1;
    }

    @Override
    public List<Engine> getAll() {
        return engineRepository.findAll();
    }

    @Override
    public Engine getById(int id) {
        return engineRepository.findById(id);
    }
}
