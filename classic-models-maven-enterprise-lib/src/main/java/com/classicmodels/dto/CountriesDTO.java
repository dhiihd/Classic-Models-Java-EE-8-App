/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.util.List;
import javax.xml.bind.annotation.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@XmlRootElement
@NoArgsConstructor
//@XmlAccessorType(XmlAccessType.FIELD)
public class CountriesDTO {

    @XmlElementWrapper
    @XmlElement(name = "country")
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @NonNull
    private List<String> countries;

}
