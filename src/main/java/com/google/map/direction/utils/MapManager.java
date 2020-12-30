package com.google.map.direction.utils;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.google.maps.model.TravelMode.DRIVING;
import static java.util.Arrays.asList;

/**
 * Created By Ponir on 29December,2020.
 */
@Slf4j
public class MapManager {

    public static GeoApiContext buildApiKey() {
        String apiKey = "YOUR_API_KEY_PASTE_HERE";
        return new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    public static List<DirectionsStep> stepsToTakeForCar(LatLng start, LatLng end) {
        List<DirectionsStep> stepsToTake = new ArrayList<>();
        try {
            DirectionsResult result = DirectionsApi.newRequest(buildApiKey())
                    .origin(start)
                    .destination(end)
                    .mode(DRIVING)
                    .await();
            if (result.routes.length > 0) {
                DirectionsRoute directionsRoute = result.routes[0];
                if (directionsRoute.legs.length > 0) {
                    DirectionsLeg legs = directionsRoute.legs[0];
                    if (legs.steps.length > 0) {
                        stepsToTake = asList(legs.steps);
                    }
                }
            }
            log.info("Data found from Map service successfully : {}", stepsToTake);
        } catch (Exception e) {
            log.error("Found error on Map service : {}", e.getMessage());
        }
        return stepsToTake;
    }
}
