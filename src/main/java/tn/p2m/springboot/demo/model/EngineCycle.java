package tn.p2m.springboot.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.p2m.springboot.demo.dto.model.EngineCycleDto;
import tn.p2m.springboot.demo.util.Sensors;
import tn.p2m.springboot.demo.util.Settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "EngineCycles")
@TypeAlias("EngineCycle")
@JsonIgnoreProperties("{measurements}")
public class EngineCycle {

static class compositeId{
    @DBRef
    public Engine engine;
    public int cycle;
    public int maintenanceIndex;
}
    @Id
    private compositeId id;
    private Date startDate ;
    private Date endDate;
    private float frequency; // Hz
    private List<Sensors> measurements = new ArrayList<Sensors>();
    public boolean getLastCycleReached()
    {
        return (id.maintenanceIndex< id.engine.getMaintenanceIndex());
    }
    private Settings settings;
    public Sensors getSensorsAvg() throws IllegalAccessException {

            Sensors sensorsAvg = new Sensors();
        if(measurements.isEmpty()) return sensorsAvg;

            for(Sensors other : measurements)

            {
                sensorsAvg = sensorsAvg.add(other);
            }
            return sensorsAvg.mulByScalar(1/(double)measurements.size());


    }
    public Sensors getSensorsStd() throws IllegalAccessException {
        Sensors sensorsStd = new Sensors();
        if(measurements.isEmpty()) return sensorsStd;

        for(Sensors other : measurements)

        {
            sensorsStd =  sensorsStd.add(other.pow(2));
        }
        sensorsStd = sensorsStd.mulByScalar(1/(double)measurements.size()).minus(this.getSensorsAvg().pow(2));
        return sensorsStd;
    }
    public Sensors getSensorsMax() throws IllegalAccessException {
        Sensors sensorsMax = new Sensors();
        if(measurements.isEmpty()) return sensorsMax;
        for (Sensors other : measurements)
        {
            sensorsMax = sensorsMax.max(other);
        }
        return sensorsMax;
    }
    public Sensors getSensorsMin() throws IllegalAccessException {
        Sensors sensorsMin = new Sensors();
        if(measurements.isEmpty()) return sensorsMin;
        for (Sensors other : measurements)
        {
            sensorsMin = sensorsMin.min(other);
        }
        return sensorsMin;
    }
    public EngineCycleDto toDto()
    {
        return new ModelMapper().map(this, EngineCycleDto.class);
    }
    public void addMeasurement(List<Sensors> measurements)
    {
        this.measurements.addAll(measurements);
    }
}
