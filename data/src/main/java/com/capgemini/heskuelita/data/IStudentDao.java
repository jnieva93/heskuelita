package com.capgemini.heskuelita.data;

import java.sql.SQLException;

import com.capgemini.heskuelita.core.beans.Student;

public interface IStudentDao {
	
	void addStudent(Student student) throws SQLException;
	
}
