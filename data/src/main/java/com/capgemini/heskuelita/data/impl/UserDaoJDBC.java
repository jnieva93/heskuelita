package com.capgemini.heskuelita.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;

public class UserDaoJDBC implements IUserDao {

    private Connection conn;

    public UserDaoJDBC (Connection conn) {
        super ();

        this.conn = conn;
    }
    

    @Override
    public User login(String userName, String password) {
       
    	User us = null;
        
        try {
            Statement stm = this.conn.createStatement ();

            ResultSet resultSet = stm.executeQuery ("SELECT * from users WHERE us_username='" + userName + "' AND us_pw='" + password + "'");

            while (resultSet.next ()) {
                us = new User ();
                us.setEmail (resultSet.getString ("us_email"));
                us.setUserName (resultSet.getString("us_username"));
                us.setPassword (resultSet.getString("us_pw"));
                break;
            }
        } catch (Exception e) {
            throw new DataException (e);
        }

        if (us == null) {
            throw new DataException ("Usuario " + userName + " desconocido");
        }

        return us;
        
    }
    
    @Override
	public void addUser(User user) throws SQLException {
		
		PreparedStatement prepStm = this.conn.prepareStatement("INSERT INTO users VALUES (?, ?, ?)");
		
		prepStm.setString(1, user.getUserName());
        prepStm.setString(2, user.getPassword());
        prepStm.setString(3, user.getEmail());

        // Ejecuta el insert
        prepStm.executeUpdate();
		
	}
    
}
