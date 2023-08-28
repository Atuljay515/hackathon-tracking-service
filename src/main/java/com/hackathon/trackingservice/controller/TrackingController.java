package com.hackathon.trackingservice.controller;

import com.hackathon.trackingservice.model.ClaimTrack;
import com.hackathon.trackingservice.service.ClaimTrackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log4j2
@RestController
public class TrackingController {

    @Autowired
    private ClaimTrackService claimTrackService;

    @PostMapping("/track")
    public Long trackClaimDetails(@RequestBody ClaimTrack claimTrack){
        ClaimTrack track = claimTrackService.trackClaimAndSaveDetails(claimTrack);
        return track.getTrackingId();
    }

    @GetMapping("/trackClaim/{id}")
    public String getClaimTrackDetails(@PathVariable Long id){
        return claimTrackService.getClaimTrackingDetails(id);
    }

    @GetMapping("/dashboard/{id}")
    public Map<String, Double> getDashboardDetails(@PathVariable Long id){
        return claimTrackService.getDashboard(id);
    }

}
