package com.server.dosopt.seminar.dto;

import lombok.Getter;

@Getter
public class HealthceckResponse {
    private String status;

    public HealthceckResponse() {
        this.status = "Ok";
    }
}