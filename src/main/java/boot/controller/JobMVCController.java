package boot.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.JobBean;
import boot.service.JobService;

@Controller
public class JobMVCController {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("/")
	public String jobsHome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/jobs")
	public String allJobs(HttpServletRequest request) {
		request.setAttribute("joblist", jobService.findAll());
		request.setAttribute("mode", "MODE_JOBS");
		return "index";
	}
	
	@GetMapping("/post-job")
	public String postNewJob(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-job")
	public String saveJob(@ModelAttribute JobBean job, BindingResult br, HttpServletRequest request ) {
		job.setPostedOn(new Date());
		jobService.save(job);
		request.setAttribute("joblist", jobService.findAll());
		request.setAttribute("mode", "MODE_JOBS");
		return "index";
	}
	
	@GetMapping("/update-job")
	public String updateJob(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("job", jobService.findJob(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-job")
	public String deleteJob(@RequestParam int id, HttpServletRequest request) {
		jobService.delete(id);
		request.setAttribute("joblist",jobService.findAll());
		request.setAttribute("mode", "MODE_JOBS");
		return "index";
	}
	
	@GetMapping("/view-job")
	public String viewJob(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("job", jobService.findJob(id));
		request.setAttribute("mode", "MODE_VIEW");
		return "index";
	}
	
	@GetMapping("/search-results")
	public String viewJob(@RequestParam String title, HttpServletRequest request) {
		request.setAttribute("joblist", jobService.findAllByTitle(title));
		request.setAttribute("mode", "MODE_JOBS");
		return "index";
	}
}
