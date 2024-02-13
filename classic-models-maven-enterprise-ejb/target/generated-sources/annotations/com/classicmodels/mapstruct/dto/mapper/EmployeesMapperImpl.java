package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.entity.Employees;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:33+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class EmployeesMapperImpl implements EmployeesMapper {

    private final CustomersMapper customersMapper = CustomersMapper.INSTANCE;
    private final OfficesMapper officesMapper = OfficesMapper.INSTANCE;

    @Override
    public Employees toEntity(EmployeesDTO employeesDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
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
        employees.setCustomersCollection( customersMapper.toEntity( employeesDTO.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employees.setEmployeesCollection( toEntity( employeesDTO.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employees.setReportsTo( employeesDTOToEmployees( employeesDTO.getReportsTo(), cycleAvoidingMappingContext ) );
        employees.setOfficeCode( officesMapper.toEntity( employeesDTO.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employees;
    }

    @Override
    public Collection<Employees> toEntity(Collection<EmployeesDTO> employeesDTOs, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Employees> target = cycleAvoidingMappingContext.getMappedInstance( employeesDTOs, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( employeesDTOs == null ) {
            return null;
        }

        Collection<Employees> collection = new ArrayList<Employees>( employeesDTOs.size() );
        cycleAvoidingMappingContext.storeMappedInstance( employeesDTOs, collection );

        for ( EmployeesDTO employeesDTO : employeesDTOs ) {
            collection.add( toEntity( employeesDTO, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public EmployeesDTO toDataObject(Employees employees, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
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
        employeesDTO.setCustomersCollection( customersMapper.toDataObject( employees.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setEmployeesCollection( toDataObject( employees.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setReportsTo( employeesToEmployeesDTO( employees.getReportsTo(), cycleAvoidingMappingContext ) );
        employeesDTO.setOfficeCode( officesMapper.toDataObject( employees.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employeesDTO;
    }

    @Override
    public Collection<EmployeesDTO> toDataObject(Collection<Employees> employees, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<EmployeesDTO> target = cycleAvoidingMappingContext.getMappedInstance( employees, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( employees == null ) {
            return null;
        }

        Collection<EmployeesDTO> collection = new ArrayList<EmployeesDTO>( employees.size() );
        cycleAvoidingMappingContext.storeMappedInstance( employees, collection );

        for ( Employees employees1 : employees ) {
            collection.add( toDataObject( employees1, cycleAvoidingMappingContext ) );
        }

        return collection;
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
        employees.setCustomersCollection( customersMapper.toEntity( employeesDTO.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employees.setEmployeesCollection( toEntity( employeesDTO.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employees.setReportsTo( toEntity( employeesDTO.getReportsTo(), cycleAvoidingMappingContext ) );
        employees.setOfficeCode( officesMapper.toEntity( employeesDTO.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employees;
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
        employeesDTO.setCustomersCollection( customersMapper.toDataObject( employees.getCustomersCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setEmployeesCollection( toDataObject( employees.getEmployeesCollection(), cycleAvoidingMappingContext ) );
        employeesDTO.setReportsTo( toDataObject( employees.getReportsTo(), cycleAvoidingMappingContext ) );
        employeesDTO.setOfficeCode( officesMapper.toDataObject( employees.getOfficeCode(), cycleAvoidingMappingContext ) );

        return employeesDTO;
    }
}
