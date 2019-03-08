package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoJDBC implements IUserDao {

    private Connection conn;

    public UserDaoJDBC(Connection conn) {
        super();

        this.conn = conn;
    }

    @Override
    public User login(String userName, String password) {

        User us = null;

        try {
            Statement stm = this.conn.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM users WHERE us_id='" + userName + "'AND us_pw='" + password + "'");

            while (resultSet.next()) {
                us = new User();
                us.setEmail(resultSet.getString("us_email"));
                us.setUserName(userName);
                break;
            }

        } catch (Exception e) {
            throw new DataException(e);
        }

        if (us == null) {
            throw  new DataException("Usuario" + userName + "inexistente");
        }

        return us;
    }
}
