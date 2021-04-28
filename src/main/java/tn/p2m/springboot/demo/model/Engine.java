package tn.p2m.springboot.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Engines")
@TypeAlias("Engine")
public class Engine {
    @Id
    private int id;
    private String description ;
    private int maintenanceIndex;
}
