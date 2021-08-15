package com.spring.jdbc.SpringJDBC;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao{

	JdbcTemplate jdbc;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public int insert(Student student) {
		int update = jdbc.update("insert into spring(customer_id,customer_name,city) values(?,?,?)",student.getId(),student.getName(),student.getCity());
		return update;
	}

	public Student select(int id) {
		String q="select * from spring where customer_id=?";
		RowMapper<Student> mapper= new RowMapperImpl(); // row mapper is used to map data to object (like dozerbean) it maps data to pojo by using resultset
		Student res = jdbc.queryForObject(q, mapper,id);
		return res;
	}

	public List<Student> selectAll() {
		String q = "select * from spring";
		RowMapper<Student> mapper = new RowMapperImpl(); // row mapper is used to map data to object (like dozerbean) it
															// maps data to pojo by using resultset
		List<Student> query = jdbc.query(q, mapper);
		return query;
	}

}
