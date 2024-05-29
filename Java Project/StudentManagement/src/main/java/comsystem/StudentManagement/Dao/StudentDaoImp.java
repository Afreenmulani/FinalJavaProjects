package comsystem.StudentManagement.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comsystem.StudentManagement.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class StudentDaoImp implements StudentDao{

	private EntityManager entitymanager;

	@Autowired
	public StudentDaoImp(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> std = entitymanager.createQuery("from Student", Student.class);
		List<Student> resultList = std.getResultList();
		return resultList;
	}

	@Override
	public Student findById(int id) {
		
		return entitymanager.find(Student.class, id);
	}

	@Override
	@Transactional
	public Student save(Student st) {
		Student dbstudent=entitymanager.merge(st);
		return dbstudent;
	}

	@Override
	@Transactional
	public String delete(int id) {
		Student student=entitymanager.find(Student.class, id);
		entitymanager.remove(student);
		return "deleted id: "+id;
	}
	




}
