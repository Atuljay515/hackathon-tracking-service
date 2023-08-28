package com.hackathon.trackingservice.service.serviceImpl;

import com.hackathon.trackingservice.model.ClaimTrack;
import com.hackathon.trackingservice.repository.ClaimTrackRepository;
import com.hackathon.trackingservice.service.ClaimTrackService;
import com.hackathon.trackingservice.service.DisbursementClient;
import com.hackathon.trackingservice.service.DocumentVerificationClient;
import com.hackathon.trackingservice.service.PolicyClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class ClaimTrackServiceImpl implements ClaimTrackService {
    private static final Logger log = LoggerFactory.getLogger(ClaimTrackServiceImpl.class);
    @Autowired(required=true)
    private DisbursementClient disbursementClient;
    @Autowired(required=true)
    private PolicyClient policyClient;
    @Autowired(required=true)
    private DocumentVerificationClient docVerClient;
    @Autowired
    private ClaimTrackRepository claimTrackRepository;


    @Override
    public ClaimTrack trackClaimAndSaveDetails(ClaimTrack claimTrack) {
        ClaimTrack claimTrack1;
        try {
            log.info("calling to disbursement service with claimId={}.",claimTrack.getClaimId());
            String status = disbursementClient.doDisbursement(claimTrack);
        claimTrack.setStatus(status);
            claimTrack1 = claimTrackRepository.save(claimTrack);
            log.info("response get from disbursement service successfully");
        }catch (Exception e){
             claimTrack1 = claimTrackRepository.save(claimTrack);
            log.warn("called to disbursement failed");
        }
        return claimTrack1;
    }

    @Override
    public String getClaimTrackingDetails(Long claimId) {
        Optional<ClaimTrack> claimTrackOptional = claimTrackRepository.findClaimTrackByClaimId(claimId);
        if(claimTrackOptional.isEmpty()){
            return "No Claim tracking detail found for this Id";
        }
        return claimTrackOptional.get().getStatus();
    }

    @Override
    public Map<String,Double> getDashboard(Long userId) {
        log.info("calling to disbursement service with userId={}.",userId);
        Map<String,Double> disbDetails = disbursementClient.getAllDisburmentDetails(userId);
        log.info("calling to policy service with userId={}.",userId);
        Map<String,Double> policyDetails = policyClient.getAllPolicyDatails(userId);
        log.info("calling to document verification service with userId={}.",userId);
        Map<String, Double> docsVerDetails = docVerClient.getAllDocsVerificationDetails(userId);
        docsVerDetails.putAll(disbDetails);
        docsVerDetails.putAll(policyDetails);
        return docsVerDetails;
    }
}
