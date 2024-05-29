package comsystem.StudentManagement.Dao;

import java.util.List;

import comsystem.StudentManagement.entity.Student;

public interface StudentDao {

	public List<Student> getAllStudents();

	public Student findById(int id);

	public Student save(Student st);

	public String delete(int id);

}
