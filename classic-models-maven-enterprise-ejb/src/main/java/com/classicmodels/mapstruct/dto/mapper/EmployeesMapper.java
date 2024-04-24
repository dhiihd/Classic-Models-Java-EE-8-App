package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.entity.Employees;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {LibraryMapper.class})
//@Mapper(uses = {PaymentsMapper.class,OrdersMapper.class})
@Mapper(uses = {CustomersMapper.class, OfficesMapper.class})
public interface EmployeesMapper extends EntityMapper<EmployeesDTO, Employees> {

    EmployeesMapper INSTANCE = Mappers.getMapper(EmployeesMapper.class);

// @Mapping(source = "library.id", target = "libraryId")
    // @Override
    // @Mapping(source = "customersCollection", target = "customersCollection")
    // @Mapping(source = "employeesCollection", target = "employeesCollection")
    //  @Mapping(source = "libraryId", target = "library")
    // @Override
    //  @Mapping(source = "customersCollection", target = "customersCollection")
    //  @Mapping(source = "employeesCollection", target = "employeesCollection")
    Employees toEntity(final EmployeesDTO employeesDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    // @Override
    //  @Mapping(source = "customersCollection", target = "customersCollection")
    //  @Mapping(source = "employeesCollection", target = "employeesCollection")
    Collection<Employees> toEntity(final Collection<EmployeesDTO> employeesDTOs,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration
    EmployeesDTO toDataObject(final Employees employees,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    // @Override
    // @Mapping(source = "customersCollection", target = "customersCollection")
    // @Mapping(source = "employeesCollection", target = "employeesCollection")
    @InheritInverseConfiguration
    Collection<EmployeesDTO> toDataObject(final Collection<Employees> employees,
            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    /*
    default Employees fromCustomerNumber(final Integer employeeNumber) {
        if (employeeNumber == null) {
            return null;
        }
        final Employees employees = new Employees();
        employees.setEmployeeNumber(employeeNumber);
        return employees;
    }
     */
}
