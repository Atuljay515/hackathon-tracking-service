package com.hackathon.trackingservice.repository;

import com.hackathon.trackingservice.model.ClaimTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaimTrackRepository extends JpaRepository<ClaimTrack, Long> {

    @Query(value="select * from track tr where tr.claim_id= :claimId", nativeQuery=true)
    public Optional<ClaimTrack> findClaimTrackByClaimId(long claimId);
}
