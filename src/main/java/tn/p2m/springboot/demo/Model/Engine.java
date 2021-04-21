package tn.p2m.springboot.demo.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import tn.p2m.springboot.demo.util.Labels;
import tn.p2m.springboot.demo.util.Sensors;
import tn.p2m.springboot.demo.util.Settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "data")
public class Engine {
    private int engineId;
    private int cycle;
    private Settings settings;
    private Sensors sensors ;
    private Labels labels ;
}
