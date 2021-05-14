package Model;

public class User {
	private String userNmae;
	private String userId;
	public User(String userNmae, String userId) {
		super();
		this.userNmae = userNmae;
		this.userId = userId;
	}
	public String getUserNmae() {
		return userNmae;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return " [userNmae=" + userNmae + ", userId=" + userId + "]";
	}
	
	
	
}
