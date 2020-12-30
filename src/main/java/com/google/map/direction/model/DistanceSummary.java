package com.google.map.direction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By Ponir on 24December,2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanceSummary {
    public Double totalDistanceInKm;
    public Long totalDurationInMin;
    public String averageSpeed;
    public int breakPoint;
}
