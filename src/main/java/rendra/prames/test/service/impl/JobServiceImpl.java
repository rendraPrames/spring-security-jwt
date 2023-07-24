package rendra.prames.test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rendra.prames.test.dto.JobDto;
import rendra.prames.test.service.JobService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Value("${app.job-list-api-url}")
    private String jobListApiUrl;

    @Value("${app.job-detail-api-url}")
    private String jobDetailApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public JobDto getJobDetail(UUID id) {
        String url = jobDetailApiUrl + "/" + id;
        ResponseEntity<JobDto> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                JobDto.class
        );

        // Convert the API response to a JobDto object
        return convertToJobResponse(Objects.requireNonNull(response.getBody()));
    }

    @Override
    public List<JobDto> getJobList() {
        // Make the API request to get the job list
        ResponseEntity<JobDto[]> response = restTemplate.exchange(
                jobListApiUrl,
                HttpMethod.GET,
                null,
                JobDto[].class
        );

        // Convert the API response to a list of JobDto
        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .map(this::convertToJobResponse)
                .toList();
    }

    private JobDto convertToJobResponse(JobDto jobDto) {
        JobDto jobResponse = new JobDto();
        jobResponse.setId(jobDto.getId());
        jobResponse.setType(jobDto.getType());
        jobResponse.setUrl(jobDto.getUrl());
        jobResponse.setCreatedAt(jobDto.getCreatedAt());
        jobResponse.setCompany(jobDto.getCompany());
        jobResponse.setCompanyUrl(jobDto.getCompanyUrl());
        jobResponse.setLocation(jobDto.getLocation());
        jobResponse.setTitle(jobDto.getTitle());
        jobResponse.setDescription(jobDto.getDescription());
        // Set other fields if needed
        return jobResponse;
    }
}