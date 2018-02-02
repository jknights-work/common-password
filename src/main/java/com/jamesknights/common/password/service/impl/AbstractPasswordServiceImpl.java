/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesknights.common.password.service.impl;

import com.jamesknights.common.java.configuration.JPAConfiguration;
import com.jamesknights.common.service.impl.AbstractService;
import com.jamesknights.common.password.service.PasswordService;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;


/**
 *
 * @author James Knights <james@i-studio.co.uk>
 */
@Service
@ContextConfiguration(
  classes = { JPAConfiguration.class })
public abstract class AbstractPasswordServiceImpl extends AbstractService implements PasswordService {
    
    private static final Logger LOG = Logger.getLogger(AbstractPasswordServiceImpl.class);
    private static final BCryptPasswordEncoder ENCRYPTER = new BCryptPasswordEncoder();

    public AbstractPasswordServiceImpl(String name) {
        super(name);
    }
    
    @Override
    public String encryptPassword (String password) {
        String result = null;
        
        if (!password.isEmpty()) {
            result = (String) ENCRYPTER.encode(password);
        }
        
        return result;
    }
    
    @Override
    public Boolean matches (String rawPassword, String encryptedPassword) {
        Boolean result = false; 
        
        if (!rawPassword.isEmpty() && !encryptedPassword.isEmpty()) {
            result = (Boolean) ENCRYPTER.matches(rawPassword, encryptedPassword);
        }
        
        return result;
    }
    
 
}
