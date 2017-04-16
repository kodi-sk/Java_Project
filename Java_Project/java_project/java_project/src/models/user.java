package models;
import java.util.Date;
public class user {
	private String name;
	private String password;
	private Date regDate;
	private String email;
	public boolean valid;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return password;
	}
	
	public void setPass(String password) {
		this.password= password;
 	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRegDate(Date regDate){
		this.regDate=regDate;
	}
	
	public Date getRegDate(){
		return regDate;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
}

