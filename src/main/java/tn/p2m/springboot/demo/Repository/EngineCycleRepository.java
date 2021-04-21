package tn.p2m.springboot.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.p2m.springboot.demo.Model.EngineCycle;

import java.util.List;

public interface EngineCycleRepository extends MongoRepository<EngineCycle,String> {
    List<EngineCycle> findByEngineId(int id);
    EngineCycle findByEngineIdAndCycle(int id, int cycle);
}
