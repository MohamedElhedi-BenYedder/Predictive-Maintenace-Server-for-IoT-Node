package tn.p2m.springboot.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import tn.p2m.springboot.demo.model.Engine;
import tn.p2m.springboot.demo.model.EngineCycle;
import tn.p2m.springboot.demo.repository.EngineCycleRepository;
import tn.p2m.springboot.demo.util.Sensors;

import java.util.List;
import java.util.Optional;

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
    public EngineCycle addMeasurement(EngineCycle engineCycle ,List<Sensors> measurements) {
        Example<EngineCycle> engineCycleExample = Example.of(engineCycle);
        Optional<EngineCycle> engineCycleOptional = engineCycleRepository.findOne(engineCycleExample);
        engineCycle = engineCycleOptional.get();
        engineCycle.addMeasurement(measurements);
        return engineCycleRepository.save(engineCycle);
    }

    @Override
    public List<EngineCycle> getAll() {
        return engineCycleRepository.findAll();
    }
    /*
        @Override
        public List<EngineCycle> getAllByEngine(Engine engine) {
            return engineCycleRepository.findByEngine(engine);
        }

        @Override
        public EngineCycle getByEngineAndCycle(Engine engine, int cycle) {
            return engineCycleRepository.findByEngineAndCycle(engine,cycle);
        }
    */
    @Override
    public void delete(EngineCycle engineCycle) {
         engineCycleRepository.delete(engineCycle);
    }
/*
    @Override
    public void deleteAllByEngine(Engine engine) {
        engineCycleRepository.deleteAllByEngine(engine);
    }
*/
    @Override
    public void clearAll() {
        engineCycleRepository.deleteAll();
    }
}
