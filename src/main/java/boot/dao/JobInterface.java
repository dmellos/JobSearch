package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.JobBean;

public interface JobInterface extends CrudRepository<JobBean, Integer> {

}
