package com.collabera.poc.log.controller;

import com.collabera.poc.log.dto.ActivityLogResponseDto;
import com.collabera.poc.log.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ActivityLogController {
    private final ActivityLogService activityLogService;

    /**
     * Get All Activity Log
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<ActivityLogResponseDto> getAllActivity() {
        return new ResponseEntity<>(
            new ActivityLogResponseDto(activityLogService.getAll()),
            HttpStatus.OK);
    }
}
