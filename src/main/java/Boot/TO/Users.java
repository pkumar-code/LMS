package Boot.TO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myusers")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;

	public Users() {}
	
	public Users(int userId, String fullName, String username, String password, String status) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public Users( String fullName, String username, String password, String status) {
		
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.status = status;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return  userId + "\t" + fullName + "\t" + username + "\t"+ password + "\t" + status ;
	}
	
	

	
	
	
}
