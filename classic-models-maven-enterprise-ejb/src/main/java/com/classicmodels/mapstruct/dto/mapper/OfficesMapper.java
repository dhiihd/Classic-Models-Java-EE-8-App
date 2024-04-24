package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.entity.Offices;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {LibraryMapper.class})
//@Mapper(uses = {PaymentsMapper.class,OrdersMapper.class})
@Mapper
public abstract class OfficesMapper implements EntityMapper<OfficesDTO, Offices> {

    public static final OfficesMapper INSTANCE = Mappers.getMapper(OfficesMapper.class);

    //  @Mapping(source = "libraryId", target = "library")
    public abstract Offices toEntity(final OfficesDTO officesDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    //   @Override
    //   @Override
    public abstract Collection<Offices> toEntity(final Collection<OfficesDTO> officesDTOs, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

// @Mapping(source = "library.id", target = "libraryId")
    @InheritInverseConfiguration
    public abstract OfficesDTO toDataObject(final Offices offices, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration
    // @Override
    public abstract Collection<OfficesDTO> toDataObject(final Collection<Offices> offices, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    /*
    default Offices fromOfficeCode(final String officeCode) {
        if (officeCode == null) {
            return null;
        }
        final Offices offices = new Offices();
        offices.setOfficeCode(officeCode);
        return offices;
    }
     */
}
