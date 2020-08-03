package com.product.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class Users {

	@Id
	private String mobileNumber;
	
	private String userName;
	
	private String emailId;
	
	private String password;
	
	private String secQuation;
	
	private String secAns;
	
	private boolean status=true;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Role> roles;

    public Users() {
    }

    public Users(Users users) {
        this.status = users.isStatus();
        this.emailId = users.getEmailId();
        this.roles = users.getRoles();
        this.userName = users.getUserName();
        this.secAns =users.getSecAns();
        this.mobileNumber = users.getMobileNumber();
        this.password = users.getPassword();
    }

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecQuation() {
		return secQuation;
	}

	public void setSecQuation(String secQuation) {
		this.secQuation = secQuation;
	}

	public String getSecAns() {
		return secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [mobileNumber=" + mobileNumber + ", userName=" + userName + ", emailId=" + emailId + ", password="
				+ password + ", secQuation=" + secQuation + ", secAns=" + secAns + ", status=" + status + ", roles="
				+ roles + "]";
	}

	
}
