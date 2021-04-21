package tn.p2m.springboot.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Labels {
    private int BNC; // Binary Classification Label
    private int MCC; // MultiClass Classification label
    private float TTF; // Time To Failure (Regression)
}
