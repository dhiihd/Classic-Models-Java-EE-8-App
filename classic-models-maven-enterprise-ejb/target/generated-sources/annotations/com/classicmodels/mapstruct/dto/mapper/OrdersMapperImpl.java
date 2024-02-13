package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.dto.OrderdetailsDTO;
import com.classicmodels.dto.OrdersDTO;
import com.classicmodels.dto.ProductsDTO;
import com.classicmodels.entity.Customers;
import com.classicmodels.entity.Employees;
import com.classicmodels.entity.Offices;
import com.classicmodels.entity.Orderdetails;
import com.classicmodels.entity.Orders;
import com.classicmodels.entity.Products;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:33+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public Orders toEntity(OrdersDTO ordersDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Orders target = cycleAvoidingMappingContext.getMappedInstance( ordersDTO, Orders.class );
        if ( target != null ) {
            return target;
        }

        if ( ordersDTO == null ) {
            return null;
        }

        Orders orders = new Orders();

        cycleAvoidingMappingContext.storeMappedInstance( ordersDTO, orders );

        orders.setOrderdetailsCollection( orderdetailsDTOCollectionToOrderdetailsCollection( ordersDTO.getOrderdetailsDTOCollection(), cycleAvoidingMappingContext ) );
        orders.setOrderNumber( ordersDTO.getOrderNumber() );
        orders.setOrderDate( ordersDTO.getOrderDate() );
        orders.setRequiredDate( ordersDTO.getRequiredDate() );
        orders.setShippedDate( ordersDTO.getShippedDate() );
        orders.setStatus( ordersDTO.getStatus() );
        orders.setComments( ordersDTO.getComments() );
        orders.setCustomerNumber( customersDTOToCustomers( ordersDTO.getCustomerNumber(), cycleAvoidingMappingContext ) );

        return orders;
    }

    @Override
    public Collection<Orders> toEntity(Collection<OrdersDTO> ordersDTOs, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Orders> target = cycleAvoidingMappingContext.getMappedInstance( ordersDTOs, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( ordersDTOs == null ) {
            return null;
        }

        Collection<Orders> collection = new ArrayList<Orders>( ordersDTOs.size() );
        cycleAvoidingMappingContext.storeMappedInstance( ordersDTOs, collection );

        for ( OrdersDTO ordersDTO : ordersDTOs ) {
            collection.add( toEntity( ordersDTO, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public OrdersDTO toDataObject(Orders orders, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        OrdersDTO target = cycleAvoidingMappingContext.getMappedInstance( orders, OrdersDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( orders == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        cycleAvoidingMappingContext.storeMappedInstance( orders, ordersDTO );

        ordersDTO.setOrderdetailsDTOCollection( orderdetailsCollectionToOrderdetailsDTOCollection( orders.getOrderdetailsCollection(), cycleAvoidingMappingContext ) );
        ordersDTO.setOrderNumber( orders.getOrderNumber() );
        ordersDTO.setOrderDate( orders.getOrderDate() );
        ordersDTO.setRequiredDate( orders.getRequiredDate() );
        ordersDTO.setShippedDate( orders.getShippedDate() );
        ordersDTO.setStatus( orders.getStatus() );
        ordersDTO.setComments( orders.getComments() );
        ordersDTO.setCustomerNumber( customersToCustomersDTO( orders.getCustomerNumber(), cycleAvoidingMappingContext ) );

        return ordersDTO;
    }

    @Override
    public Collection<OrdersDTO> toDataObject(Collection<Orders> orders, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<OrdersDTO> target = cycleAvoidingMappingContext.getMappedInstance( orders, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( orders == null ) {
            return null;
        }

        Collection<OrdersDTO> collection = new ArrayList<OrdersDTO>( orders.size() );
        cycleAvoidingMappingContext.storeMappedInstance( orders, collection );

        for ( Orders orders1 : orders ) {
            collection.add( toDataObject( orders1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    protected Products productsDTOToProducts(ProductsDTO productsDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Products target = cycleAvoidingMappingContext.getMappedInstance( productsDTO, Products.class );
        if ( target != null ) {
            return target;
        }

        if ( productsDTO == null ) {
            return null;
        }

        Products products = new Products();

        cycleAvoidingMappingContext.storeMappedInstance( productsDTO, products );

        products.setProductCode( productsDTO.getProductCode() );
        products.setProductName( productsDTO.getProductName() );
        products.setProductScale( productsDTO.getProductScale() );
        products.setProductVendor( productsDTO.getProductVendor() );
        products.setProductDescription( productsDTO.getProductDescription() );
        products.setQuantityInStock( productsDTO.getQuantityInStock() );
        products.setBuyPrice( productsDTO.getBuyPrice() );
        products.setMsrp( productsDTO.getMsrp() );

        return products;
    }

    protected Orderdetails orderdetailsDTOToOrderdetails(OrderdetailsDTO orderdetailsDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Orderdetails target = cycleAvoidingMappingContext.getMappedInstance( orderdetailsDTO, Orderdetails.class );
        if ( target != null ) {
            return target;
        }

        if ( orderdetailsDTO == null ) {
            return null;
        }

        Orderdetails orderdetails = new Orderdetails();

        cycleAvoidingMappingContext.storeMappedInstance( orderdetailsDTO, orderdetails );

        orderdetails.setQuantityOrdered( orderdetailsDTO.getQuantityOrdered() );
        orderdetails.setPriceEach( orderdetailsDTO.getPriceEach() );
        orderdetails.setOrderLineNumber( orderdetailsDTO.getOrderLineNumber() );
        orderdetails.setOrders( toEntity( orderdetailsDTO.getOrders(), cycleAvoidingMappingContext ) );
        orderdetails.setProducts( productsDTOToProducts( orderdetailsDTO.getProducts(), cycleAvoidingMappingContext ) );

        return orderdetails;
    }

    protected Collection<Orderdetails> orderdetailsDTOCollectionToOrderdetailsCollection(Collection<OrderdetailsDTO> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Orderdetails> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<Orderdetails> collection1 = new ArrayList<Orderdetails>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( OrderdetailsDTO orderdetailsDTO : collection ) {
            collection1.add( orderdetailsDTOToOrderdetails( orderdetailsDTO, cycleAvoidingMappingContext ) );
        }

        return collection1;
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

    protected ProductsDTO productsToProductsDTO(Products products, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        ProductsDTO target = cycleAvoidingMappingContext.getMappedInstance( products, ProductsDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( products == null ) {
            return null;
        }

        ProductsDTO productsDTO = new ProductsDTO();

        cycleAvoidingMappingContext.storeMappedInstance( products, productsDTO );

        productsDTO.setProductCode( products.getProductCode() );
        productsDTO.setProductName( products.getProductName() );
        productsDTO.setProductScale( products.getProductScale() );
        productsDTO.setProductVendor( products.getProductVendor() );
        productsDTO.setProductDescription( products.getProductDescription() );
        productsDTO.setQuantityInStock( products.getQuantityInStock() );
        productsDTO.setBuyPrice( products.getBuyPrice() );
        productsDTO.setMsrp( products.getMsrp() );

        return productsDTO;
    }

    protected OrderdetailsDTO orderdetailsToOrderdetailsDTO(Orderdetails orderdetails, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        OrderdetailsDTO target = cycleAvoidingMappingContext.getMappedInstance( orderdetails, OrderdetailsDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( orderdetails == null ) {
            return null;
        }

        OrderdetailsDTO orderdetailsDTO = new OrderdetailsDTO();

        cycleAvoidingMappingContext.storeMappedInstance( orderdetails, orderdetailsDTO );

        orderdetailsDTO.setQuantityOrdered( orderdetails.getQuantityOrdered() );
        orderdetailsDTO.setPriceEach( orderdetails.getPriceEach() );
        orderdetailsDTO.setOrderLineNumber( orderdetails.getOrderLineNumber() );
        orderdetailsDTO.setOrders( toDataObject( orderdetails.getOrders(), cycleAvoidingMappingContext ) );
        orderdetailsDTO.setProducts( productsToProductsDTO( orderdetails.getProducts(), cycleAvoidingMappingContext ) );

        return orderdetailsDTO;
    }

    protected Collection<OrderdetailsDTO> orderdetailsCollectionToOrderdetailsDTOCollection(Collection<Orderdetails> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<OrderdetailsDTO> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<OrderdetailsDTO> collection1 = new ArrayList<OrderdetailsDTO>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( Orderdetails orderdetails : collection ) {
            collection1.add( orderdetailsToOrderdetailsDTO( orderdetails, cycleAvoidingMappingContext ) );
        }

        return collection1;
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
