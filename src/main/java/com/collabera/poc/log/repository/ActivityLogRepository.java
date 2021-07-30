package com.collabera.poc.log.repository;

import com.collabera.poc.log.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog, Long> {
    List<ActivityLog> findAll();
}
