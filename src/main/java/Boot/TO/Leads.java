package Boot.TO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myleads")
public class Leads {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="leadId")
	private int leadId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="courseInterest")
	private String courseInterest;
	
	@Column(name="collegeName")
	private String collegeName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="status")
	private String status;
	
	
	public Leads() {}


	public Leads(int leadId, String name, String email, long phone, String courseInterest, String collegeName,
			String city, String status) {
		super();
		this.leadId = leadId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.courseInterest = courseInterest;
		this.collegeName = collegeName;
		this.city = city;
		this.status = status;
	}
	
	public Leads( String name, String email, long phone, String courseInterest, String collegeName,
			String city, String status) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.courseInterest = courseInterest;
		this.collegeName = collegeName;
		this.city = city;
		this.status = status;
	}


	public int getLeadId() {
		return leadId;
	}


	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getCourseInterest() {
		return courseInterest;
	}


	public void setCourseInterest(String courseInterest) {
		this.courseInterest = courseInterest;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return  leadId + "\t" + name + "\t" + email + "\t" + phone
				+ "\t" + courseInterest + "\t" + collegeName + "\t" + city + "\t"+ status ;
	}
	
	

}
