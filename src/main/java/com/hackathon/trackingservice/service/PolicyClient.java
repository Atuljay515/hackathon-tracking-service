package com.hackathon.trackingservice.service;

import com.hackathon.trackingservice.model.ClaimTrack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value ="POLICY-SERVICE", url = "http://localhost:1111")
public interface PolicyClient {

    @GetMapping( "/getAllPolicyDetails/{id}")
    public Map<String,Double> getAllPolicyDatails(@RequestBody Long id);
}
