package com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;

public class SecurityServiceImpl implements ISecurityService {

    private IUserDao userDao;


    public SecurityServiceImpl (IUserDao userDao) {
        super ();

        this.userDao = userDao;
    }

    
    @Override
    public void login (UserAnnotation user) throws SecurityException {

        try {
            this.userDao.login (user.getUserName(), user.getPassword());
        } catch (Exception e) {
            throw new SecurityException(e);
        }
        
    }
    
}
