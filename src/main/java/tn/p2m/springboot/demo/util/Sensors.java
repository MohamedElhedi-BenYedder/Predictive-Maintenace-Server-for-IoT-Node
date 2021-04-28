package tn.p2m.springboot.demo.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sensors {
    private double ax ;
    private double ay ;
    private double az ;
    private double temperature ;
    private double hygrometry;
    private double temperatureIndex;
    public Sensors add(Sensors other) throws IllegalAccessException {
        Sensors result = new Sensors();
        Field[] sensorsFields = Sensors.class.getDeclaredFields();
        for (Field field:sensorsFields)
        {

            field.setDouble(result,(double)field.get(this)+(double)field.get(other));

        }
        return result;
    }
    public Sensors minus(Sensors other) throws IllegalAccessException {
        Sensors result = new Sensors();
        Field[] sensorsFields = Sensors.class.getDeclaredFields();
        for (Field field:sensorsFields)
        {

            field.setDouble(result,(double)field.get(this)-(double)field.get(other));

        }
        return result;
    }
    public Sensors mulByScalar(double scalar) throws IllegalAccessException {
        Sensors result = new Sensors();
        Field[] sensorsFields = Sensors.class.getDeclaredFields();
        for (Field field:sensorsFields)
        {

            field.setDouble(result,(double)field.get(this)*scalar);

        }
        return result;

    }
    public Sensors pow(double scalar) throws IllegalAccessException {
        Sensors result = new Sensors();
        Field[] sensorsFields = Sensors.class.getDeclaredFields();
        for (Field field:sensorsFields)
        {

            field.setDouble(result,Math.pow((double)field.get(this),scalar));

        }
        return result;

    }
    public Sensors max(Sensors other) throws IllegalAccessException {
        Sensors result = new Sensors();
        Field[] sensorsFields = Sensors.class.getDeclaredFields();
        for (Field field:sensorsFields)
        {

            field.setDouble(result,Math.max((double)field.get(this),(double)field.get(other)));

        }
        return result;

    }
    public Sensors min(Sensors other) throws IllegalAccessException {
        Sensors result = new Sensors();
        Field[] sensorsFields = Sensors.class.getDeclaredFields();
        for (Field field:sensorsFields)
        {

            field.setDouble(result,Math.min((double)field.get(this),(double)field.get(other)));

        }
        return result;

    }
}
