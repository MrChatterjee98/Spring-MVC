package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.model.Student;



@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	Session session;
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public int addStudent(Student student) {
		this.session = sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		return (int) session.save(student);
		
	}

	@Override
	public Student viewStudentById(int id) {
		this.session = sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		return session.get(Student.class, id);
		
	}

	@Override
	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		this.session = sessionFactory.getCurrentSession();
		Query<Student> query = session.createQuery("FROM Student");
		
		return (List<Student>)query.list();
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
		// TODO Auto-generated method stub
		this.session = sessionFactory.getCurrentSession();
		
		Student st = session.get(Student.class,id);
		session.delete(st);
		return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		this.session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
		return student;
	}

	
	
	

}
