package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.entity.Customers;
import com.classicmodels.entity.Employees;
import com.classicmodels.entity.Offices;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:32+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class CustomersMapperImpl extends CustomersMapper {

    @Override
    public Collection<CustomersDTO> toDataObject(Collection<Customers> customers, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<CustomersDTO> target = cycleAvoidingMappingContext.getMappedInstance( customers, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( customers == null ) {
            return null;
        }

        Collection<CustomersDTO> collection = new ArrayList<CustomersDTO>( customers.size() );
        cycleAvoidingMappingContext.storeMappedInstance( customers, collection );

        for ( Customers customers1 : customers ) {
            collection.add( toDataObject( customers1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public CustomersDTO toDataObject(Customers customers, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        CustomersDTO target = cycleAvoidingMappingContext.getMappedInstance( customers, CustomersDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( customers == null ) {
            return null;
        }

        CustomersDTO customersDTO = new CustomersDTO();

        cycleAvoidingMappingContext.storeMappedInstance( customers, customersDTO );

        customersDTO.setSalesRepEmployeeNumber( employeesToEmployeesDTO( customers.getSalesRepEmployeeNumber(), cycleAvoidingMappingContext ) );
        customersDTO.setCustomerNumber( customers.getCustomerNumber() );
        customersDTO.setCustomerName( customers.getCustomerName() );
        customersDTO.setContactLastName( customers.getContactLastName() );
        customersDTO.setContactFirstName( customers.getContactFirstName() );
        customersDTO.setPhone( customers.getPhone() );
        customersDTO.setAddressLine1( customers.getAddressLine1() );
        customersDTO.setAddressLine2( customers.getAddressLine2() );
        customersDTO.setCity( customers.getCity() );
        customersDTO.setState( customers.getState() );
        customersDTO.setPostalCode( customers.getPostalCode() );
        customersDTO.setCountry( customers.getCountry() );
        customersDTO.setCreditLimit( customers.getCreditLimit() );

        ignoreCustomers( customers, customersDTO );

        return customersDTO;
    }

    @Override
    public Customers toEntity(CustomersDTO customersDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Customers target = cycleAvoidingMappingContext.getMappedInstance( customersDTO, Customers.class );
        if ( target != null ) {
            return target;
        }

        if ( customersDTO == null ) {
            return null;
        }

        Customers customers = new Customers();

        cycleAvoidingMappingContext.storeMappedInstance( customersDTO, customers );

        customers.setCustomerNumber( customersDTO.getCustomerNumber() );
        customers.setCustomerName( customersDTO.getCustomerName() );
        customers.setContactLastName( customersDTO.getContactLastName() );
        customers.setContactFirstName( customersDTO.getContactFirstName() );
        customers.setPhone( customersDTO.getPhone() );
        customers.setAddressLine1( customersDTO.getAddressLine1() );
        customers.setAddressLine2( customersDTO.getAddressLine2() );
        customers.setCity( customersDTO.getCity() );
        customers.setState( customersDTO.getState() );
        customers.setPostalCode( customersDTO.getPostalCode() );
        customers.setCountry( customersDTO.getCountry() );
        customers.setCreditLimit( customersDTO.getCreditLimit() );
        customers.setSalesRepEmployeeNumber( employeesDTOToEmployees( customersDTO.getSalesRepEmployeeNumber(), cycleAvoidingMappingContext ) );

        return customers;
    }

    @Override
    public Collection<Customers> toEntity(Collection<CustomersDTO> customersDTOs, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Customers> target = cycleAvoidingMappingContext.getMappedInstance( customersDTOs, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( customersDTOs == null ) {
            return null;
        }

        Collection<Customers> collection = new ArrayList<Customers>( customersDTOs.size() );
        cycleAvoidingMappingContext.storeMappedInstance( customersDTOs, collection );

        for ( CustomersDTO customersDTO : customersDTOs ) {
            collection.add( toEntity( customersDTO, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    protected Collection<EmployeesDTO> employeesCollectionToEmployeesDTOCollection(Collection<Employees> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<EmployeesDTO> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<EmployeesDTO> collection1 = new ArrayList<EmployeesDTO>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( Employees employees : collection ) {
            collection1.add( employeesToEmployeesDTO( employees, cycleAvoidingMappingContext ) );
        }

        return collection1;
    }

    protected OfficesDTO officesToOfficesDTO(Offices offices, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        OfficesDTO target = cycleAvoidingMappingContext.getMappedInstance( offices, OfficesDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( offices == null ) {
            return null;
        }

        OfficesDTO officesDTO = new OfficesDTO();

        cycleAvoidingMappingContext.storeMappedInstance( offices, officesDTO );

        officesDTO.setOfficeCode( offices.getOfficeCode() );
        officesDTO.setCity( offices.getCity() );
        officesDTO.setPhone( offices.getPhone() );
        officesDTO.setAddressLine1( offices.getAddressLine1() );
        officesDTO.setAddressLine2( offices.getAddressLine2() );
        officesDTO.setState( offices.getState() );
        officesDTO.setCountry( offices.getCountry() );
        officesDTO.setPostalCode( offices.getPostalCode() );
        officesDTO.setTerritory( offices.getTerritory() );
        officesDTO.setEmployeesCollection( employeesCollectionToEmployeesDTOCollection( offices.getEmployeesCollection(), cycleAvoidingMappingContext ) );

        return officesDTO;
    }

    protected EmployeesDTO employeesToEmployeesDTO(Employees employees, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        EmployeesDTO target = cycleAvoidingMappingContext.getMappedInstance( employees, EmployeesDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( employees == null ) {
            return null;
        }

        EmployeesDTO employeesDTO = new EmployeesDTO();

        cycleAvoidingMappingContext.storeMappedInstance( employees, employeesDTO );

        employeesDTO.setEmployeeNumber( employees.getEmployeeNumber() );
        employeesDTO.setLastName( employees.getLastName() );
        employeesDTO.setFirstName( employees.getFirstName() );
        employeesDTO.setExtension( employees.getExtension() );
        employeesDTO.setEmail( employees.getEmail() );
        employeesDTO.setJobTitle( employees.getJobTitle() );
        employeesDTO.setCustomersCollection( toDataObject( employees.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setEmployeesCollection( employeesCollectionToEmployeesDTOCollection( employees.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setReportsTo( employeesToEmployeesDTO( employees.getReportsTo(), cycleAvoidingMappingContext ) );
        employeesDTO.setOfficeCode( officesToOfficesDTO( employees.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employeesDTO;
    }

    protected Collection<Employees> employeesDTOCollectionToEmployeesCollection(Collection<EmployeesDTO> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Employees> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<Employees> collection1 = new ArrayList<Employees>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( EmployeesDTO employeesDTO : collection ) {
            collection1.add( employeesDTOToEmployees( employeesDTO, cycleAvoidingMappingContext ) );
        }

        return collection1;
    }

    protected Offices officesDTOToOffices(OfficesDTO officesDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Offices target = cycleAvoidingMappingContext.getMappedInstance( officesDTO, Offices.class );
        if ( target != null ) {
            return target;
        }

        if ( officesDTO == null ) {
            return null;
        }

        Offices offices = new Offices();

        cycleAvoidingMappingContext.storeMappedInstance( officesDTO, offices );

        offices.setCity( officesDTO.getCity() );
        offices.setPhone( officesDTO.getPhone() );
        offices.setAddressLine1( officesDTO.getAddressLine1() );
        offices.setAddressLine2( officesDTO.getAddressLine2() );
        offices.setState( officesDTO.getState() );
        offices.setCountry( officesDTO.getCountry() );
        offices.setPostalCode( officesDTO.getPostalCode() );
        offices.setTerritory( officesDTO.getTerritory() );
        offices.setOfficeCode( officesDTO.getOfficeCode() );
        offices.setEmployeesCollection( employeesDTOCollectionToEmployeesCollection( officesDTO.getEmployeesCollection(), cycleAvoidingMappingContext ) );

        return offices;
    }

    protected Employees employeesDTOToEmployees(EmployeesDTO employeesDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Employees target = cycleAvoidingMappingContext.getMappedInstance( employeesDTO, Employees.class );
        if ( target != null ) {
            return target;
        }

        if ( employeesDTO == null ) {
            return null;
        }

        Employees employees = new Employees();

        cycleAvoidingMappingContext.storeMappedInstance( employeesDTO, employees );

        employees.setLastName( employeesDTO.getLastName() );
        employees.setFirstName( employeesDTO.getFirstName() );
        employees.setExtension( employeesDTO.getExtension() );
        employees.setEmail( employeesDTO.getEmail() );
        employees.setJobTitle( employeesDTO.getJobTitle() );
        employees.setEmployeeNumber( employeesDTO.getEmployeeNumber() );
        employees.setCustomersCollection( toEntity( employeesDTO.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employees.setEmployeesCollection( employeesDTOCollectionToEmployeesCollection( employeesDTO.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employees.setReportsTo( employeesDTOToEmployees( employeesDTO.getReportsTo(), cycleAvoidingMappingContext ) );
        employees.setOfficeCode( officesDTOToOffices( employeesDTO.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employees;
    }
}
