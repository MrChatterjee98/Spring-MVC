package mvc.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import spring.config.HibernateConfig;
import spring.model.LoginModel;
import spring.model.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HibernateConfig.class)
@WebAppConfiguration
public class ControllerTest {

	@InjectMocks
	MockMvc mvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	String username;
	
	
	@BeforeEach
	public void setup() throws Exception {
	    this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	    this.username = "Test"+Math.ceil((int)Math.random()*10);
	}
	
	@Test
	@DisplayName("Login page test")
	public void landingTesst() throws Exception {
		mvc.perform(get("/")).andExpect(view().name("login")).andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Login Success test")
	public void loginTest() throws Exception {
		mvc.perform(post("/login")
				.param("username", "ADMIN1")
				.param("password", "ADMIN"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeExists("student"));
	}
	@Test
	@DisplayName("Login Fail test")
	public void loginTestError() throws Exception {
		mvc.perform(post("/login")
				.param("username", "admin")
				.param("password", "admin1"))
		.andExpect(status().isUnauthorized())
		.andExpect(view().name("ErrorPage"));
		
	}
	@Test
	@DisplayName("Registration page")
	public void registrationLandingPageTest() throws Exception {
		mvc.perform(get("/register")).andExpect(view().name("registration")).andExpect(model().attributeExists("login")).andExpect(status().isOk());
	}
	@Test
	@DisplayName("Registration Successful flow")
	public void rgistrationPositiveFlow() throws Exception {
		LoginModel model = new LoginModel(this.username,"12345","Student");
		mvc.perform(post("/registration").flashAttr("login", model)).andExpect(status().isOk())
			.andExpect(view().name("demo")).andExpect(model().attribute("message", "Registration successful"));
		
	}
	@Test
	@DisplayName("Registration Unsuccessful flow 1")
	public void registrationNegativeFlowOne() throws Exception{
		
		LoginModel model = new LoginModel("Tester12","12345","Student");
		mvc.perform(post("/registration").flashAttr("login", model)).andExpect(status().isInternalServerError())
			.andExpect(view().name("demo")).andExpect(model().attribute("message", "Registartion not successful"));

	}
	@Test
	@DisplayName("Registration Unsuccessful flow 2")
	public void registrationNegativeFlowTwo() throws Exception{
		
		LoginModel model = new LoginModel("Tester12","","Student");
		mvc.perform(post("/registration").flashAttr("login", model)).andExpect(status().isInternalServerError())
			.andExpect(view().name("demo")).andExpect(model().attribute("message", "Registartion not successful"));
	}
	@Test
	@DisplayName("Insert Student Positive Flow")
	public void insertStudentPositiveFlow() throws Exception{
		Student s = new Student();
		s.setFirstName("Biswarup");
		s.setLastName("Chatterjee");
		s.setAge(24);
		
		mvc.perform(post("/add").flashAttr("student", s))
			.andExpect(status().isOk())
			.andExpect(view().name("demo"))
			.andExpect(model().attribute("message", "student successfully inserted"));
	}
	@Test
	@DisplayName("Insert Student Negative Flow")
	public void insertStudentNegativeFlow() throws Exception{
		Student s = new Student();
		
		mvc.perform(post("/add").flashAttr("student", s))
			.andExpect(status().isInternalServerError())
			.andExpect(view().name("demo"))
			.andExpect(model().attribute("message", "an error occured"));
	}
	@Test
	@DisplayName("find Student")
	public void findStudent() throws Exception{
		mvc.perform(post("/find").param("studentId", "1"))
			.andExpect(status().isOk())
			.andExpect(view().name("studentinfo"))
			.andExpect(model().attribute("student",hasProperty("firstName",is("Biswarup"))))
			.andExpect(model().attribute("student",hasProperty("lastName",is("Chatterjee"))))
			.andExpect(model().attribute("student",hasProperty("age",is(24))));
	}
	@Test
	@DisplayName("find student negative flow")
	public void findStudentNegative() throws Exception {
		mvc.perform(post("/find").param("studentId", "0"))
			.andExpect(status().isNotFound())
			.andExpect(view().name("studentinfo"))
			.andExpect(model().attributeDoesNotExist("student"));

	}
	
	@Test
	@DisplayName("update student")
	public void updateStudent() throws Exception {
		mvc.perform(post("/update").param("id", "2").param("option", "firstName").param("value","ABC"))
			.andExpect(status().isOk())
			.andExpect(view().name("studentinfo"))
			.andExpect(model().attribute("student", hasProperty("firstName",is("ABC"))));
	}
	@Test
	@DisplayName("delete student")
	public void deleteStudent() throws Exception{
		mvc.perform(post("/delete").param("studentId", "1"))
		.andExpect(status().isOk())
		.andExpect(view().name("demo"))
		.andExpect(model().attribute("message", "Student deleted successfully"));
	}
	@Test
	@DisplayName("delete student negative flow")
	public void deleteStudentNegativeFlow() throws Exception{
		mvc.perform(post("/delete").param("studentId", "1"))
		.andExpect(status().isInternalServerError())
		.andExpect(view().name("demo"))
		.andExpect(model().attribute("message", "Registartion not successful"));
	}
	
	
	
	
	

}
