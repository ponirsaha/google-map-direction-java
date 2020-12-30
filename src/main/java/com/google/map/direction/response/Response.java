package com.google.map.direction.response;

import com.google.map.direction.model.Direction;
import com.google.map.direction.model.DistanceSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created By Ponir on 24December,2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private List<Direction> directions;
    private DistanceSummary summary;
}
