package spring.dao;

import java.util.List;

import spring.model.Student;

public interface StudentDao {

	
	public int addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public Student viewStudentById(int id);
	
	public List<Student> viewAllStudents();
	
	public boolean deleteStudent(int id);
	
	
	
}
