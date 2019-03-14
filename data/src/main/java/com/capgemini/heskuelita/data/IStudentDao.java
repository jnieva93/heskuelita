package com.capgemini.heskuelita.data;

import java.sql.SQLException;

import com.capgemini.heskuelita.data.entity.StudentAnnotation;

public interface IStudentDao {
	
	void addStudent(StudentAnnotation student) throws SQLException;
	
}
