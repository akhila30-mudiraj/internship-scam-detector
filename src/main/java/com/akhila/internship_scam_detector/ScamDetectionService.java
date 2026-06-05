package com.akhila.internship_scam_detector;

import org.springframework.stereotype.Service;

@Service
public class ScamDetectionService {

    public DetectionResult analyze(InternshipRequest request) {

        int score = 0;

        if (request.getRegistrationFee() > 0) {
            score += 30;
        }

        if (request.getEmail() != null &&
                (request.getEmail().contains("gmail.com")
                        || request.getEmail().contains("yahoo.com"))) {
            score += 20;
        }

        if (request.getWebsite() == null ||
                request.getWebsite().isBlank()) {
            score += 20;
        }

        if (request.getStipend() > 50000) {
            score += 30;
        }

        String status;

        if (score >= 70) {
            status = "🔴 HIGH RISK SCAM";
        } else if (score >= 30) {
            status = "🟡 SUSPICIOUS";
        } else {
            status = "🟢 LIKELY GENUINE";
        }

        return new DetectionResult(status, score);
    }
}