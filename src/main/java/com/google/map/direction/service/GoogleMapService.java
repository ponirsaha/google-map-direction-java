package com.google.map.direction.service;

import com.google.map.direction.model.Direction;
import com.google.map.direction.model.DistanceSummary;
import com.google.map.direction.response.Response;
import com.google.maps.model.LatLng;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.map.direction.helper.StringHelper.*;
import static com.google.map.direction.utils.MapManager.stepsToTakeForCar;

/**
 * Created By Ponir on 23December,2020.
 */
@Slf4j
@Service
public class GoogleMapService {

    public Response findDirection(LatLng start, LatLng end) {

        List<Direction> directions = new ArrayList<>();
        List<Long> totalDistance = new ArrayList<>();
        List<Long> totalDuration = new ArrayList<>();

        stepsToTakeForCar(start, end).forEach(directionsStep -> {
            Direction direction = new Direction();
            direction.setDistance(directionsStep.distance.humanReadable);
            direction.setDuration(directionsStep.duration.humanReadable);
            direction.setPolyline(directionsStep.polyline.decodePath());
            direction.setStep(html2text(directionsStep.htmlInstructions));
            directions.add(direction);
            totalDistance.add(directionsStep.distance.inMeters);
            totalDuration.add(directionsStep.duration.inSeconds);
        });

        return new Response(directions, new DistanceSummary(totalDistance(totalDistance),
                totalDuration(totalDuration), averagedSpeedCalculate(totalDistance(totalDistance),
                totalDuration(totalDuration)), directions.size()));
    }
}
