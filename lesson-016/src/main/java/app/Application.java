package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		StudentDao studentDao = ctx.getBean("studentDaoImpl", StudentDaoImpl.class);

		System.out.println("Get all students: ");
		studentDao.getAllStudents().forEach(System.out::println);

		System.out.println("Update student with id = 1");
		Student student = studentDao.getAllStudents().get(1);
		student.setName("Thomas");
		student.setAge(101);
		studentDao.updateStudent(student);
		studentDao.getAllStudents().forEach(System.out::println);

		System.out.println("Delete student with id = 1");
		studentDao.deleteStudent(1);
		studentDao.getAllStudents().forEach(System.out::println);

		System.out.println("Add student from Configuration");
		Student s = ctx.getBean("student", Student.class);
		studentDao.create(s);
		studentDao.getAllStudents().forEach(System.out::println);

	}
}