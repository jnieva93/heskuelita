
package com.capgemini.heskuelita.data;


import com.capgemini.heskuelita.core.beans.User;


public interface IUserDao {

    User login (String userName, String password);
}