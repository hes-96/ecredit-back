package payload.request;

import java.util.Set;
 
public class SignupRequest {
    
    @Override
	public String toString() {
		return "SignupRequest [username=" + username + ", email=" + email + ", role=" + role + ", password=" + password
				+ "]";
	}

	private String username;
 
    
    private String email;
    
    private Set<String> role;
    
    
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
