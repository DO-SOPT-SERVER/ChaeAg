package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.HealthceckResponse;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheckV1() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3() {
        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthceckResponse> healthCheckV5() {
        return ResponseEntity.ok(new HealthceckResponse());
    }

}