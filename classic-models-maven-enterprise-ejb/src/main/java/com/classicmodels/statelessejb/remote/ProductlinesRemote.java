/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.ProductlinesDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface ProductlinesRemote {
    

    public void create(ProductlinesDTO productlinesDTO) ;

    public void edit(Integer id, ProductlinesDTO productlinesDTO);

    public void edit(ProductlinesDTO productlinesDTO) ;

    public void remove(Integer id);

    public ProductlinesDTO find(Integer id);

    public Collection<ProductlinesDTO> findRange(Integer from, Integer to);

    public Collection<ProductlinesDTO> findAll();
    
    public String countREST();

}
