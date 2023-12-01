package com.demo;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceCalculatorController {

    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    @GetMapping("/calculateDistance")
    public DistanceMatrix calculateDistance(
            @RequestParam double originLat, @RequestParam double originLng,
            @RequestParam double destinationLat, @RequestParam double destinationLng) {
        LatLng origin = new LatLng(originLat, originLng);
        LatLng destination = new LatLng(destinationLat, destinationLng);
        return distanceCalculatorService.calculateDistance(origin, destination);
    }
    @GetMapping("/calculateDistances")
    public DistanceAndTimeResponse calculateDistance(
            @RequestParam String origin, @RequestParam String destination) {

        DistanceAndTimeResponse response= distanceCalculatorService.getDistanceMatrix(origin, destination);
//        DistanceAndTimeResponse.Rows rows = response.getRows().get(0);
//        String text = rows.getElement().get(0).getDistance().getText();
        System.out.println();
        return response;

    }
}