package com.hackathon.trackingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Map;
@FeignClient(value ="DOCUMENT-VERIFICATION-SERVICE", url = "http://localhost:2222")
public interface DocumentVerificationClient {
        @GetMapping( "/getDocsVerDetails/{id}")
        public Map<String,Double> getAllDocsVerificationDetails(@PathVariable Long id);
}
