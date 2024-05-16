package model;

public class account {
	private String username;
	private String password;
	private String id;
	
	public account() {
		super();
	}
	
	public account(String id,String username, String password) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
