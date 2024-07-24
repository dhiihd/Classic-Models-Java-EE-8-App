/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.CustomersDTO;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface CustomersRemote {

    public void create(CustomersDTO customersDTO);

    public void edit(Integer id, CustomersDTO customersDTO);

    public void edit(CustomersDTO customersDTO);

    public void remove(Integer id);

    public CustomersDTO find(Integer id);

    public Collection<CustomersDTO> findRange(Integer from, Integer to);

    public Collection<CustomersDTO> findAll();

    public List<String> findCountries();

    public CustomersDTO findByCustomerNumber(Integer id);

    public String countREST();

    public List<BigDecimal> findCustomerCreditLimits(String country);

    //public Collection<String> findCountries();
    public Collection<CustomersDTO> findCustomersList();

}
