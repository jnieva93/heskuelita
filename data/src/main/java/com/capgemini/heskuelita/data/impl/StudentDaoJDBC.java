package com.capgemini.heskuelita.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.IStudentDao;

// Tendra un comportamiento similar a UserDaoJDBC
public class StudentDaoJDBC implements IStudentDao {
	
	private Connection conn;
	
	public StudentDaoJDBC(Connection conn) {
		super();
		
		this.conn = conn;
	}

	@Override
	public void addStudent(Student student) throws SQLException {
		
		// CUANDO USAR GETCONNECTION?
		PreparedStatement prepStm = this.conn.prepareStatement("INSERT INTO student VALUES (default, ?, ?, ?, ?, ?, ?, ?)");
		
		prepStm.setString(1, student.getName());
        prepStm.setString(2, student.getLastName());
        prepStm.setString(3, student.getDni());
        prepStm.setString(4, student.getPhone());
        prepStm.setString(5, student.getAddress());
        prepStm.setString(6, student.getGender());
        prepStm.setString(7, student.getUserName());

        // Ejecuta el insert
        prepStm.executeUpdate();
		
	}
	
}
