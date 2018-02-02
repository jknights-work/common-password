/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesknights.common.password.service;


import com.jamesknights.common.password.service.impl.LocalPasswordService;
import com.jamesknights.common.service.ServiceException;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import static org.aspectj.bridge.MessageUtil.fail;


import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;


/**
 *
 * @author James Knights <james@i-studio.co.uk>
 */


public class PasswordServiceTest {
    
    @InjectMocks
    private final LocalPasswordService SERVICE = new LocalPasswordService("passwordService");
    
    @Test
    public void setPassword() {
        if (!SERVICE.isRunning()) {
            try {
                SERVICE.start();
            } catch (ServiceException e) {
                fail("Unable to start Service", e);
            }
        }
         String rawPassword = "abc123";
         String newPassword = SERVICE.encryptPassword(rawPassword);
         assertThat(rawPassword, not(newPassword));
         
         try {
            SERVICE.stop();
        } catch (ServiceException ex) {
            fail("failed to stop cleanly -" + ex.getMessage());
        }
        
    }
    
    @Test
    public void matchPassword() {
        if (!SERVICE.isRunning()) {
            try {
                SERVICE.start();
            } catch (ServiceException e) {
                fail("Unable to start Service", e);
            }
        }
         String rawPassword = "abc123";
         String newPassword = SERVICE.encryptPassword(rawPassword);
         assertThat(rawPassword, not(newPassword));
         
         boolean matches = SERVICE.matches(rawPassword, newPassword);
         
         assertTrue(matches);
         
         try {
            SERVICE.stop();
        } catch (ServiceException ex) {
            fail("failed to stop cleanly -" + ex.getMessage());
        }
        
    }
    
}
