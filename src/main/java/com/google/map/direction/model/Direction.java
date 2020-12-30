package com.google.map.direction.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.LatLng;
import com.google.maps.model.TransitDetails;
import com.google.maps.model.TravelMode;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created By Ponir on 24December,2020.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Direction implements Serializable {
    private static final long serialVersionUID = 1L;
    public String step;
    public String distance;
    public String duration;
    public LatLng startLocation;
    public LatLng endLocation;
    public DirectionsStep[] steps;
    public List<LatLng> polyline;
    public TravelMode travelMode;
    public TransitDetails transitDetails;
}
