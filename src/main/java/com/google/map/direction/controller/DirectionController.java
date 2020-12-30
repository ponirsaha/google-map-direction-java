package com.google.map.direction.controller;

import com.google.map.direction.model.LatLong;
import com.google.map.direction.service.GoogleMapService;
import com.google.maps.model.LatLng;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Ponir on 24December,2020.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/public")
public class DirectionController {
    private final GoogleMapService googleMapService;

    public DirectionController(GoogleMapService googleMapService) {
        this.googleMapService = googleMapService;
    }

    @PostMapping("/direction")
    public ResponseEntity<?> getDirection(@RequestBody LatLong latLong) {
        try {
            return ResponseEntity.ok(googleMapService.findDirection(
                    new LatLng(latLong.getSource().getLat(), latLong.getSource().getLng()),
                    new LatLng(latLong.getDestination().getLat(), latLong.getDestination().getLng())
            ));
        } catch (Exception e) {
            log.error("Found error on fetching map : {}", e.getMessage());
            return null;
        }
    }
}
