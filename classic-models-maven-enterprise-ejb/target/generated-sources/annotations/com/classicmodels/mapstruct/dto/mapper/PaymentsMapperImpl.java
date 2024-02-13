package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.dto.PaymentsDTO;
import com.classicmodels.entity.Customers;
import com.classicmodels.entity.Employees;
import com.classicmodels.entity.Offices;
import com.classicmodels.entity.Payments;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:32+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class PaymentsMapperImpl implements PaymentsMapper {

    @Override
    public Payments toEntity(PaymentsDTO paymentsDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Payments target = cycleAvoidingMappingContext.getMappedInstance( paymentsDTO, Payments.class );
        if ( target != null ) {
            return target;
        }

        if ( paymentsDTO == null ) {
            return null;
        }

        Payments payments = new Payments();

        cycleAvoidingMappingContext.storeMappedInstance( paymentsDTO, payments );

        payments.setPaymentDate( paymentsDTO.getPaymentDate() );
        payments.setAmount( paymentsDTO.getAmount() );
        payments.setCustomers( customersDTOToCustomers( paymentsDTO.getCustomers(), cycleAvoidingMappingContext ) );

        return payments;
    }

    @Override
    public Collection<Payments> toEntity(Collection<PaymentsDTO> paymentsDTOs, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Payments> target = cycleAvoidingMappingContext.getMappedInstance( paymentsDTOs, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( paymentsDTOs == null ) {
            return null;
        }

        Collection<Payments> collection = new ArrayList<Payments>( paymentsDTOs.size() );
        cycleAvoidingMappingContext.storeMappedInstance( paymentsDTOs, collection );

        for ( PaymentsDTO paymentsDTO : paymentsDTOs ) {
            collection.add( toEntity( paymentsDTO, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public PaymentsDTO toDataObject(Payments payments, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        PaymentsDTO target = cycleAvoidingMappingContext.getMappedInstance( payments, PaymentsDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( payments == null ) {
            return null;
        }

        PaymentsDTO paymentsDTO = new PaymentsDTO();

        cycleAvoidingMappingContext.storeMappedInstance( payments, paymentsDTO );

        paymentsDTO.setPaymentDate( payments.getPaymentDate() );
        paymentsDTO.setAmount( payments.getAmount() );
        paymentsDTO.setCustomers( customersToCustomersDTO( payments.getCustomers(), cycleAvoidingMappingContext ) );

        return paymentsDTO;
    }

    @Override
    public Collection<PaymentsDTO> toDataObject(Collection<Payments> payments, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<PaymentsDTO> target = cycleAvoidingMappingContext.getMappedInstance( payments, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( payments == null ) {
            return null;
        }

        Collection<PaymentsDTO> collection = new ArrayList<PaymentsDTO>( payments.size() );
        cycleAvoidingMappingContext.storeMappedInstance( payments, collection );

        for ( Payments payments1 : payments ) {
            collection.add( toDataObject( payments1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    protected Collection<Customers> customersDTOCollectionToCustomersCollection(Collection<CustomersDTO> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Customers> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<Customers> collection1 = new ArrayList<Customers>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( CustomersDTO customersDTO : collection ) {
            collection1.add( customersDTOToCustomers( customersDTO, cycleAvoidingMappingContext ) );
        }

        return collection1;
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
        employees.setCustomersCollection( customersDTOCollectionToCustomersCollection( employeesDTO.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employees.setEmployeesCollection( employeesDTOCollectionToEmployeesCollection( employeesDTO.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employees.setReportsTo( employeesDTOToEmployees( employeesDTO.getReportsTo(), cycleAvoidingMappingContext ) );
        employees.setOfficeCode( officesDTOToOffices( employeesDTO.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employees;
    }

    protected Customers customersDTOToCustomers(CustomersDTO customersDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
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

    protected Collection<CustomersDTO> customersCollectionToCustomersDTOCollection(Collection<Customers> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<CustomersDTO> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<CustomersDTO> collection1 = new ArrayList<CustomersDTO>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( Customers customers : collection ) {
            collection1.add( customersToCustomersDTO( customers, cycleAvoidingMappingContext ) );
        }

        return collection1;
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
        employeesDTO.setCustomersCollection( customersCollectionToCustomersDTOCollection( employees.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setEmployeesCollection( employeesCollectionToEmployeesDTOCollection( employees.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setReportsTo( employeesToEmployeesDTO( employees.getReportsTo(), cycleAvoidingMappingContext ) );
        employeesDTO.setOfficeCode( officesToOfficesDTO( employees.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employeesDTO;
    }

    protected CustomersDTO customersToCustomersDTO(Customers customers, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
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

        return customersDTO;
    }
}
