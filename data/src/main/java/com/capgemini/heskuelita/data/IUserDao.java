package com.capgemini.heskuelita.data;

import java.sql.SQLException;

import com.capgemini.heskuelita.core.beans.User;

public interface IUserDao {

    User login(String userName, String password);

	void addUser(User user) throws SQLException;
	
}
