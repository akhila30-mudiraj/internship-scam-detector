package com.akhila.internship_scam_detector;

public class DetectionResult {

    private String status;
    private int score;

    public DetectionResult(String status, int score) {
        this.status = status;
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }
}