/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.EmployeesDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface EmployeesRemote {
    

    public void create(EmployeesDTO employeesDTO) ;

    public void edit(Integer id, EmployeesDTO mployeesDTO);

    public void edit(EmployeesDTO employeesDTO) ;

    public void remove(Integer id);

    public EmployeesDTO find(Integer id);

    public Collection<EmployeesDTO> findRange(Integer from, Integer to);

    public Collection<EmployeesDTO> findAll();
    
    public String countREST();

}
