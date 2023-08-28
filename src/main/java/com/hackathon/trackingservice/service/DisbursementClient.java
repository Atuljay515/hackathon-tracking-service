package com.hackathon.trackingservice.service;

import com.hackathon.trackingservice.model.ClaimTrack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

//change hardcode url
@FeignClient(value ="DISBURSEMENT-SERVICE", url = "http://localhost:1111")
public interface DisbursementClient {
    @PostMapping( "/doDisbursement")
    public String doDisbursement(@RequestBody ClaimTrack claimTrack);

    @GetMapping( "/getDisbursementDetails/{id}")
    public Map<String,Double> getAllDisburmentDetails(@PathVariable Long id);
}
