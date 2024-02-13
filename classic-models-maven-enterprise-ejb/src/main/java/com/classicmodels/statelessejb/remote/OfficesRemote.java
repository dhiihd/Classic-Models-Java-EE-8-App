/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.OfficesDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface OfficesRemote {
    

    public void create(OfficesDTO officesDTO) ;

    public void edit(String id, OfficesDTO officesDTO);

    public void edit(OfficesDTO officesDTO) ;

    public void remove(String id);

    public OfficesDTO find(String id);

    public Collection<OfficesDTO> findRange(Integer from, Integer to);

    public Collection<OfficesDTO> findAll();
    
    public String countREST();

}
