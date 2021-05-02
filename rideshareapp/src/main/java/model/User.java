package model;

public class User extends Person {
	private String userid;
	private boolean isPreffereduser;
	
	public User(String name,long mobile) {
		// TODO Auto-generated constructor stub
		this.Name=name;
		this.contact=mobile;
		this.isPreffereduser=false;
	}
	
	public void setPreffereduser(boolean isPreffereduser) {
		this.isPreffereduser = isPreffereduser;
	}

	public boolean isPreffereduser() {
		return isPreffereduser;
	}
	
}
