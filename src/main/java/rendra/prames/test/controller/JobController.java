package rendra.prames.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rendra.prames.test.dto.JobDto;
import rendra.prames.test.service.JobService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/list")
    public ResponseEntity<List<JobDto>> getJobList() {
            List<JobDto> jobs = jobService.getJobList();
            return ResponseEntity.ok(jobs);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<JobDto> getJobDetail(@PathVariable UUID id) {
        JobDto job = jobService.getJobDetail(id);
        return ResponseEntity.ok(job);
    }
}