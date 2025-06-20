package com.example.alumniconnect.service;

import com.example.alumniconnect.entity.Job;
import com.example.alumniconnect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired private JobRepository jobRepo;
    public List<Job> getAll() { return jobRepo.findAll(); }
    public Job save(Job j) { return jobRepo.save(j); }
    public void delete(Long id) { jobRepo.deleteById(id); }
}