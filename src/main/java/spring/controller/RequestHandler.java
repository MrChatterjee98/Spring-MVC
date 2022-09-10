package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.model.LoginModel;
import spring.model.Student;
import spring.service.LoginService;
import spring.service.StudentService;

@Controller
public class RequestHandler {
	
	@Autowired
	StudentService service;

	@Autowired
	LoginService loginService;
	
	@RequestMapping(path = "/")
	public ModelAndView getMessage() {
		ModelAndView mv =new ModelAndView("login");
		
		return mv;
	}
	
	@RequestMapping(path="/login",method = RequestMethod.POST)
	public ModelAndView getToLoginPage(@RequestParam("username") String uname,@RequestParam("password") String pass) {
		ModelAndView mv;
		if(loginService.loginValidation(uname, pass)) {
		mv =new ModelAndView("index");
		mv.addObject("student", new Student());
		
		}
		else
			mv = new ModelAndView("ErrorPage");
		return mv;
	}
	
	@RequestMapping(path = "/add",method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute("student") Student student) {
		ModelAndView mv = new ModelAndView("demo");
		try {
		System.out.println(student);
		service.insert(student);
		
		mv.addObject("message", "student successfully inserted");
		
		}
		catch(Exception ex) {
		mv.addObject("message","and error occured");
		ex.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path = "/find", method = RequestMethod.POST)
	public ModelAndView findStudent(@RequestParam("studentId") int id) {
		ModelAndView mv = new ModelAndView("studentinfo");
		
		Student student = service.findStudent(id);
		mv.addObject("student", student);
		return mv;
		
	}
	@RequestMapping(path = "/findall", method = RequestMethod.POST)
	public ModelAndView viewStudents() {
		ModelAndView mv = new ModelAndView("viewallstudents");
		List<Student> students = service.listAllStudent();
		System.out.println(students);
		mv.addObject("students",students);
		return mv;
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam("id") String id,@RequestParam("option") String option,@RequestParam("value")String value) {
		ModelAndView mv = new ModelAndView("studentinfo");
		
		Student st = service.update(id, option, value);
		mv.addObject("student",st);
		
		return mv;
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteStudent(@RequestParam("studentId") int id) {
		ModelAndView mv = new ModelAndView("demo");
		String message;
		if(service.delete(id))
			message = "Student deleted successfully";
		else
			message = "Student deletion unsuccessful";
		mv.addObject("message", message);
		return mv;
		
	}

	@RequestMapping(path = "/registration",method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("login") LoginModel loginModel) {
		ModelAndView mv = new ModelAndView("demo");
		boolean flag = loginModel.getUsername().length() !=0 && loginModel.getPassword().length() !=0;
		if(loginService.registration(loginModel) && flag)
			mv.addObject("message","Registration successful");
		else
			mv.addObject("message","Registartion not successful");
		return mv;
	}

	@RequestMapping(path="/register")
	public ModelAndView getRegistrationPage() {
		return new ModelAndView("registration","login",new LoginModel());
	}
	
}
