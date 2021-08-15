package com.spring.jdbc.SpringJDBC;

import java.util.List;

public interface StudentDao {
	
	public int insert(Student student);
	public Student select(int id);
	public List<Student> selectAll();

}
