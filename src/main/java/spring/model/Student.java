package spring.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Student {
	@Id
	private int studentId;
	@Column(name ="fist_name")
	private String firstName;
	@Column(name ="last_name")
	private String lastName;
	
	private int age;
}
