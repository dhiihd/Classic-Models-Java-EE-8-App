package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.entity.Customers;
import com.classicmodels.entity.Offices;
import com.classicmodels.statelessejb.CustomersFacade;
import java.util.Collection;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Mapper(uses = {LibraryMapper.class})
//@Mapper(uses = {PaymentsMapper.class,OrdersMapper.class})
//@Mapper(uses = {EmployeesMapper.class})
@Mapper
public abstract class CustomersMapper implements EntityMapper<CustomersDTO, Customers> {

    private static final Logger logger
            = LoggerFactory.getLogger(CustomersMapper.class);

    @AfterMapping
    protected void ignoreCustomers(Customers customers, @MappingTarget CustomersDTO customersDTO) {
        logger.info("Inside ignoreCustomersEmployees");
        customersDTO.setSalesRepEmployeeNumber(null);
    }

    public static final CustomersMapper INSTANCE = Mappers.getMapper(CustomersMapper.class);

// @Mapping(source = "library.id", target = "libraryId")
    @InheritInverseConfiguration
    public abstract Collection<CustomersDTO> toDataObject(final Collection<Customers> customers,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    //   @Mapping(source = "salesRepEmployeeNumber", target = "salesRepEmployeeNumber")
    @InheritInverseConfiguration
    @Override
    public abstract CustomersDTO toDataObject(final Customers customers,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    // @Mapping(source = "customerNumber", target = "customerNumber")
    public abstract Customers toEntity(final CustomersDTO customersDTO,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    public abstract Collection<Customers> toEntity(final Collection<CustomersDTO> customersDTOs,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    /**
     * public Customers fromCustomerNumber(final Integer customerNumber) { if
     * (customerNumber == null) { return null; } final Customers customers = new
     * Customers(); customers.setCustomerNumber(customerNumber); return
     * customers; }
     *
     * default CustomersDTO toEntity(Customers customers) { return
     * toEntity(customers, new CycleAvoidingMappingContext()); }
     *
     */
}
