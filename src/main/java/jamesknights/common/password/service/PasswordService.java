/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamesknights.common.password.service;

import com.jamesknights.common.service.Service;



/**
 *
 * @author James Knights <james@i-studio.co.uk>
 */
public interface PasswordService extends Service {
    
    String encryptPassword (String password);
    
    Boolean matches (String password, String ePassword);
    
    //other methods below
    
    
    
}
