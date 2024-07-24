/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@XmlRootElement
@NoArgsConstructor
//@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersListDTO {

    @XmlElementWrapper
    @XmlElement(name = "customersList")
    public Collection<CustomersDTO> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(Collection<CustomersDTO> customersList) {
        this.customersList = customersList;
    }

    @NonNull
    private Collection<CustomersDTO> customersList;

}
