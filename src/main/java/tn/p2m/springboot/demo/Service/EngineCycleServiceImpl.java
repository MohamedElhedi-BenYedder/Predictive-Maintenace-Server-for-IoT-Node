package tn.p2m.springboot.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tn.p2m.springboot.demo.Model.EngineCycle;
import tn.p2m.springboot.demo.Repository.EngineCycleRepository;

import java.util.List;

@Component
public class EngineCycleServiceImpl implements EngineCycleService {
    @Autowired
    EngineCycleRepository engineCycleRepository;

    @Override
    public EngineCycle create(EngineCycle engineCycle) {
        return engineCycleRepository.save(engineCycle);
    }

    @Override
    public EngineCycle update(EngineCycle engineCycle) {
        return null;
    }

    @Override
    public List<EngineCycle> getAll() {
        return engineCycleRepository.findAll();
    }

    @Override
    public List<EngineCycle> getById(int id) {
        return engineCycleRepository.findByEngineId(id);
    }

    @Override
    public EngineCycle getByIdAndCycle(int id, int cycle) {
        return engineCycleRepository.findByEngineIdAndCycle(id,cycle);
    }

    @Override
    public int newId() {
        return engineCycleRepository.findAll(Sort.by(Sort.Direction.DESC,"appointmentNumber")).get(0).getEngineId()+1;
    }

    @Override
    public void delete(EngineCycle engineCycle) {
         engineCycleRepository.delete(engineCycle);
    }

    @Override
    public void clearAll() {
        engineCycleRepository.deleteAll();
    }
}
