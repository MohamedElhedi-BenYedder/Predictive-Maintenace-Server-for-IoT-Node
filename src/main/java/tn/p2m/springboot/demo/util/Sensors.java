package tn.p2m.springboot.demo.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sensors {
    float ax;
    float ay;
    float az;
    float temperature;
}
