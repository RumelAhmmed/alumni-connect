package com.example.alumniconnect.controller;

import com.example.alumniconnect.entity.Job;
import com.example.alumniconnect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public String jobs(Model model) {
        model.addAttribute("jobs", jobService.getAll());
        model.addAttribute("job", new Job());  // <-- Important for Thymeleaf form binding
        return "jobs";
    }

    @PostMapping("/jobs")
    public String addJob(Job job) {
        jobService.save(job);
        return "redirect:/jobs";
    }
}
