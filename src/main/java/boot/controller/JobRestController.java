package boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.service.JobService;



@RestController
public class JobRestController {
	
	@Autowired
	private JobService jobService;
	
	
	@GetMapping("/job-list")
	public String jobList() {
		return jobService.findAll().toString();
	}
	
}
