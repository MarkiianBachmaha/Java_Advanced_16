package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model.Student;

@Configuration
public class CustomConfiguration {

	@Bean(name = "student")
	public Student getStudent() {
		Student student = new Student();
		student.setId(6);
		student.setName("Bob");
		student.setAge(26);

		return student;
	}
}