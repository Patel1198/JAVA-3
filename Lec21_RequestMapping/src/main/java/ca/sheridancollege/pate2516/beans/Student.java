package ca.sheridancollege.pate2516.beans;

import java.time.LocalDate;

public class Student {

	private String fName;
	private String lName;
	private String email;
	private Long SID;
	private LocalDate DOB;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getSID() {
		return SID;
	}
	public void setSID(Long SID) {
		this.SID = SID;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate DOB) {
		this.DOB = DOB;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", email=" + email + ", SID=" + SID + ", DOB=" + DOB
				+ "]";
	}
	
	
}
