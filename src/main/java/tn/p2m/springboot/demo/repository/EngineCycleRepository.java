package tn.p2m.springboot.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.p2m.springboot.demo.model.Engine;
import tn.p2m.springboot.demo.model.EngineCycle;

import java.util.List;

public interface EngineCycleRepository extends MongoRepository<EngineCycle,String> {
  //  List<EngineCycle> findByEngine(Engine engine);
   // EngineCycle findByEngineAndCycle(Engine engine, int cycle);
   // void deleteAllByEngine(Engine engine);
}
