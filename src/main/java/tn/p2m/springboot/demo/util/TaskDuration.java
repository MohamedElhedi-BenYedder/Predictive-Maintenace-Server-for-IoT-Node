package tn.p2m.springboot.demo.util;

import java.util.Date;

public class TaskDuration {
    int minutes;
    int seconds;
    int milliseconds;

    public TaskDuration(int minutes, int seconds, int milliseconds) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }
    public TaskDuration(Date startDate, Date endDate)
    {
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        double diff = (endTime-startTime)/1000.0;
        minutes = (int) (diff /60);
        seconds = (int) (diff-minutes*60);
        milliseconds = (int) ((diff - seconds - minutes*60 )*1000);
    }
    public String toString() { return minutes+" mn: "+seconds +" s: "+milliseconds+" ms"+" ~ ";}
    public String toString(String format) {
        switch (format) {
            case "mn:s":
                return minutes + " mn: " + seconds + milliseconds / 1000.0 + " s";
            case "mn:ms":
                return minutes + " mn: " + seconds * 1000 + milliseconds + " ms";
            case "s:ms":
                return minutes * 60 + seconds + "s: " + seconds * 1000 + milliseconds + " ms";
            case "s":
                return minutes * 60 + seconds + milliseconds / 1000.0 + " s";
            case "ms":
                return (minutes * 60 + seconds) * 1000 + milliseconds + " ms";
        }
        return minutes+" mn: "+seconds +" s: "+milliseconds+" ms";
    }


}
