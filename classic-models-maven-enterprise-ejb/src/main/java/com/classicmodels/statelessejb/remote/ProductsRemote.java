/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.ProductsDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface ProductsRemote {

    public void create(ProductsDTO productsDTO);

    public void edit(Integer id, ProductsDTO productsDTO);

    public void edit(ProductsDTO productsDTO);

    public void remove(Integer id);

    public ProductsDTO find(Integer id);

    public Collection<ProductsDTO> findRange(Integer from, Integer to);

    public Collection<ProductsDTO> findAll();

    public String countREST();

}
