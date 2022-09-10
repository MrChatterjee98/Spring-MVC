package spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class LoginModel {
	@Id
	private String username;
	private String password;
	private String role;
}
