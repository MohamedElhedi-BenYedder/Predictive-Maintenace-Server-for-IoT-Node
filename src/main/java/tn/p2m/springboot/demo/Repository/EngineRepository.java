package tn.p2m.springboot.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.p2m.springboot.demo.Model.Engine;

import java.util.List;

public interface EngineRepository extends MongoRepository<Engine,String> {
    List<Engine> findByEngineId(int id);
    Engine findByEngineIdAndCycle(int id,int cycle);
}
