/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.inter;

import com.bsptechs.entities.Role;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface IRoleService {
    
    
    public List<Role> selectAll();

}
