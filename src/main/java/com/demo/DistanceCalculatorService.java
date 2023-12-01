package com.demo;

import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Instant;

@Service
public class DistanceCalculatorService {

    private static final String API_KEY = "AIzaSyD14gNhrZ-Jq66sZcd9WzN6pyKPmqYRmbo";
    private static final String BASE_URL="https://maps.googleapis.com/maps/api/distancematrix/json";
    @Autowired
    private RestTemplate restTemplate;
    private static final GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();

    public DistanceMatrix calculateDistance(LatLng origin, LatLng destination) {
        try {
            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
            DistanceMatrix matrix = req.origins(origin)
                    .destinations(destination)
                    .mode(TravelMode.DRIVING)
                    .language("fr-FR")
                    .await();
            if (matrix.rows.length > 0 && matrix.rows[0].elements.length > 0) {
                Distance distance = matrix.rows[0].elements[0].distance;

                System.out.println("Distance Text: " + distance.humanReadable);
                System.out.println("Distance Value: " + distance.inMeters);

            } else {
                System.out.println("No distance information available in the matrix.");
            }
            return matrix;
        } catch (ApiException | InterruptedException | IOException e) {
            throw new RuntimeException("Error calculating distance", e);
        }
    }



    public DistanceAndTimeResponse getDistanceMatrix(String origins, String destinations) {
        String apiUrl = BASE_URL +
                "?origins=" + origins +
                "&destinations=" + destinations +
                "&key=" + API_KEY;

        return restTemplate.getForObject(apiUrl, DistanceAndTimeResponse.class);
    }
}