package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.JobInterface;
import boot.model.JobBean;

@Transactional
@Service
public class JobService {

	private final JobInterface jobDao;

	public JobService(JobInterface jobDao) {
		super();
		this.jobDao = jobDao;
	}
	
	public List<JobBean> findAll(){
		List<JobBean> jobList = new ArrayList<>();
		for(JobBean job : jobDao.findAll()){
			jobList.add(job);
		}
		return jobList;
	}
	
	public void save(JobBean job) {
		jobDao.save(job);
	}
	
	public void delete(int id) {
		jobDao.delete(id);
	}
	
	public JobBean findJob(int id) {
		return jobDao.findOne(id);
	}
	
	public List<JobBean> findAllByTitle(String title){
		List<JobBean> jobList = new ArrayList<>();
		for(JobBean job: jobDao.findAllByTitle(title)) {
			jobList.add(job);
		}
		return jobList;
	}
}
