package tn.p2m.springboot.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.p2m.springboot.demo.model.Engine;

public interface EngineRepository extends MongoRepository<Engine,String> {
    public Engine findById(int id);
}
