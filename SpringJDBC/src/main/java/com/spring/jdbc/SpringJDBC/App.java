package com.spring.jdbc.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//	hi	ApplicationContext app = new ClassPathXmlApplicationContext("configau_com.xml");
		ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfig.class);
		StudentDao ss = (StudentDaoImpl) app.getBean(StudentDaoImpl.class);
//		Student st = new Student();
//		st.setId(4);
//		st.setName("JamesAndreson");
//		st.setCity("Glasgow");
//		int insert = ss.insert(st);
//		System.out.println(insert);
//		Student result = ss.select(4);
		List<Student> selectAll = ss.selectAll();
		selectAll.forEach(result->{
			System.out.println(result.getId()+" "+result.getCity()+" "+result.getName());
		});
		
	}
}
