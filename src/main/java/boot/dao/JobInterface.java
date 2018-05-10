package boot.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import boot.model.JobBean;

public interface JobInterface extends CrudRepository<JobBean, Integer>{
	List<JobBean> findAllByTitle(String title);
}
