package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.data.entity.UserAnnotation;

public interface ISecurityService {

    void login (UserAnnotation user) throws SecurityException;
    
}
