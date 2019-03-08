package com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;

public class SecurityServiceImpl implements ISecurityService {

    private IUserDao userDao;
    private DBConnectionManager manager;

    public SecurityServiceImpl(IUserDao userDao) {
        super();

        this.userDao = userDao;
    }

    @Override
    public void login(User user) throws SecurityException {
        try {
            // Si funciona, devuelve un objeto usuario
            user = this.userDao.login(user.getUserName(), user.getPassword());
        } catch (Exception e) {
            throw new SecurityException(e);
        }
    }

}
