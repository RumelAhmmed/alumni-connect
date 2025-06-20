package com.example.alumniconnect.repository;

import com.example.alumniconnect.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {}