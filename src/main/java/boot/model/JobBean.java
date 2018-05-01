package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="jobsearch")
public class JobBean implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String title;
	private String category;
	
	@Column(name="description")
	private String desc;
	
	private String location;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date postedOn;
	
	public JobBean() {}
	
	public JobBean(String title, String category, String desc, String location, Date postedOn) {
		super();
		this.title = title;
		this.category = category;
		this.desc = desc;
		this.location = location;
		this.postedOn = postedOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	
	@Override
	public String toString() {
		return "JobBean [id=" + id + ", title=" + title + ", category=" + category + ", desc=" + desc + ", location="
				+ location + ", postedOn=" + postedOn + "]";
	}
	
	
	
	
}
