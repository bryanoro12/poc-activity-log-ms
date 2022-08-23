package com.collabera.poc.log.dto;

import com.collabera.poc.log.entity.ActivityLog;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ActivityLogResponseDto {
    private List<ActivityLog> activityLogs;
}
