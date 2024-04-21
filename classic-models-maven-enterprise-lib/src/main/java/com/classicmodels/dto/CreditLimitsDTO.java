/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@XmlRootElement
@NoArgsConstructor
//@XmlAccessorType(XmlAccessType.FIELD)
public class CreditLimitsDTO {

    @XmlElementWrapper
    @XmlElement(name = "creditLimit")
    public List<BigDecimal> getCreditLimits() {
        return creditLimits;
    }

    public void setCreditLimits(List<BigDecimal> creditLimits) {
        this.creditLimits = creditLimits;
    }

    @NonNull
    private List<BigDecimal> creditLimits;

}
