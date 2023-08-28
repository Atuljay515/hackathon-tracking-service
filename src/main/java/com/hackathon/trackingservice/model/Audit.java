package com.hackathon.trackingservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;
    private Long claimId;
    private String claimType;
    private String claimantCondition;
    private Integer yearOfClaim;
    private Integer claimValidity;
    private String status;
    private Long policyId;
    private String policeName;
    private BigDecimal coveredAmount;
    private BigDecimal premiumAmount;
    private String policyType;
    private Float policyPeriod;
}
