package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.OrderdetailsDTO;
import com.classicmodels.entity.Orderdetails;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {LibraryMapper.class})
@Mapper(uses = {OrdersMapper.class,ProductsMapper.class})
public interface OrderdetailsMapper extends EntityMapper<OrderdetailsDTO, Orderdetails> {

    OrderdetailsMapper INSTANCE = Mappers.getMapper(OrderdetailsMapper.class);

// @Mapping(source = "library.id", target = "libraryId")
    @Mapping(source = "orderdetailsKeyDTO", target = "orderdetailsPK")
    @Override
    Orderdetails toEntity(final OrderdetailsDTO orderdetailsDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    Collection<Orderdetails> toEntity(final Collection<OrderdetailsDTO> orderdetailsDTOs, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    @InheritInverseConfiguration
    OrderdetailsDTO toDataObject(final Orderdetails orderdetails, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    @InheritInverseConfiguration
    Collection<OrderdetailsDTO> toDataObject(final Collection<Orderdetails> orderdetails, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    /*
 default Orderdetails fromOrderdetailsPK(final OrderdetailsPK orderdetailsPK) {
        if (orderdetailsPK == null) {
            return null;
        }
        final Orderdetails orderdetails = new Orderdetails();
        orderdetails.setOrderdetailsPK(orderdetailsPK);
        return orderdetails;
    }
     */
}
