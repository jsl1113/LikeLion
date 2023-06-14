package com.example.mybatis;

import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MybatisApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MybatisApplication.class, args);
		StudentDao dao = applicationContext.getBean(StudentDao.class);
		System.out.println(dao.readStudentsAll());

		Student student = new Student();
		student.setName("dave");
		student.setAge(40);
		student.setPhone("010-1111-2222");
		student.setEmail("dave@naver.com");
		dao.createStudent(student);
		System.out.println(dao.readStudentsAll());
		System.out.println(dao.readStudent(1L));
		System.out.println(dao.readStudent(2L));
		System.out.println(dao.readStudent(3L));

		System.out.println(dao.readAllXml());
	}

}
