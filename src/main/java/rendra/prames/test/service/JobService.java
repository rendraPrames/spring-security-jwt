package rendra.prames.test.service;

import rendra.prames.test.dto.JobDto;

import java.util.List;
import java.util.UUID;

public interface JobService {

    List<JobDto> getJobList();

    JobDto getJobDetail(UUID id);
}
