package tn.p2m.springboot.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.p2m.springboot.demo.util.TaskDuration;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Tasks")
@TypeAlias("task")
public enum Task {
    DataWrangling(0),MultiClassClassification(),BinaryClassification(),Regression();
    private int index;
    private int maxIterNumber = 100000;
    private TaskDuration duration;
    Task(int index)
    {
        this.index=index;
    }
    public int getIndex()
    {
        return index;
    }

    public int getMaxIterNumber() {
        return maxIterNumber;
    }
    public void setMaxIterNumber(int maxIterNumber)
    {
        this.maxIterNumber=maxIterNumber;
    }
}
