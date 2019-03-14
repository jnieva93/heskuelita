package com.capgemini.heskuelita.data;

import java.sql.SQLException;

import com.capgemini.heskuelita.data.entity.UserAnnotation;

public interface IUserDao {

    UserAnnotation login(String userName, String password);

	void addUser(UserAnnotation user) throws SQLException;
	
}
