package com.hackathon.trackingservice.service;

import com.hackathon.trackingservice.model.Audit;
import com.hackathon.trackingservice.model.ClaimTrack;

import java.util.Map;

public interface ClaimTrackService {

    public abstract ClaimTrack trackClaimAndSaveDetails(ClaimTrack claimTrack);
    public abstract String getClaimTrackingDetails(Long claimId);
    public abstract Map<String,Double> getDashboard(Long userId);

}
