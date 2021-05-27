package dao;

import java.util.List;

import model.Student;

public interface StudentDao {

	public List<Student> getAllStudents();

	public boolean create(Student student);

	public Student getStudent(Integer id);

	public boolean updateStudent(Student student);

	public boolean deleteStudent(Integer id);

}