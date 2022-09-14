package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.StudentDao;
import spring.model.Student;



@Service
public class StudentService {

	
	@Autowired
	StudentDao dao;
	
	@Transactional
	public int insert(Student student) throws Exception {
		if(student.getFirstName() == null || student.getLastName() == null || student.getAge() == 0)
			throw new Exception();
			
		 return dao.addStudent(student);
	}
	@Transactional
	public Student findStudent(int id) throws Exception {
		Student st = null; 
		st = dao.viewStudentById(id);
		if(st == null)
			throw new Exception();
		return st;
	}
	@Transactional
	public List<Student> listAllStudent(){
			return dao.viewAllStudents();
	}
	
	public Student update(String id, String option,String value) {
		int sid = Integer.parseInt(id);
		Student st = dao.viewStudentById(sid);
		System.out.println(st);
		if(option.equalsIgnoreCase("age"))
			st.setAge(Integer.parseInt(value));
		else if(option.equalsIgnoreCase("firstName")) {
			
			st.setFirstName(value);}
		else if(option.equalsIgnoreCase("lastName"))
			st.setLastName(value);
		dao.updateStudent(st);
		return st;
	}
	
	public boolean delete(int id) {
		return dao.deleteStudent(id);
	}
}
