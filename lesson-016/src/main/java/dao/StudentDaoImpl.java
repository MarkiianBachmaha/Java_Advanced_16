package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Student;

@Component
public class StudentDaoImpl implements StudentDao {

	List<Student> students;

	@Autowired
	public StudentDaoImpl() {
		students = new ArrayList<>();
		Student student1 = new Student(0, "James", 16);
		Student student2 = new Student(1, "Frank", 26);
		Student student3 = new Student(2, "Paul", 36);
		Student student4 = new Student(3, "Dave", 46);
		Student student5 = new Student(4, "Charlie", 56);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
	}

	@Override
	public List<Student> getAllStudents() {
		return students;
	}

	@Override
	public boolean create(Student student) {
		return students.add(student);
	}

	@Override
	public Student getStudent(Integer id) {
		return students.get(id);
	}

	@Override
	public boolean updateStudent(Student student) {
		Student s = students.get(student.getId());
		if (s != null) {
			s.setName(student.getName());
			s.setAge(student.getAge());
			System.out.println("Student: id " + student.getId() + " updated;");
			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteStudent(Integer id) {
		Student s = students.remove(id.intValue());
		if (s != null) {
			System.out.println("Student: id " + id + " removed from database");
			return true;
		} else
			return false;
	}
}