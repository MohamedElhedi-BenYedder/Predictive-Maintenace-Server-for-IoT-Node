package tn.p2m.springboot.demo.util.body;

import tn.p2m.springboot.demo.model.EngineCycle;
import tn.p2m.springboot.demo.util.Sensors;

import java.util.List;

public class AddMeasurementRequestBody {
    public EngineCycle engineCycle;
    public List<Sensors> measurements;
}
