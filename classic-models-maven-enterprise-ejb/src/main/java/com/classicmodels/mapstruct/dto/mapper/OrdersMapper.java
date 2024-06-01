package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.OrdersDTO;
import com.classicmodels.entity.Orders;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderdetailsMapper.class})
//@Mapper
public interface OrdersMapper extends EntityMapper<OrdersDTO, Orders> {

    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    // @Mapping(source = "library.id", target = "libraryId")
    @Mapping(source = "orderdetailsDTOCollection", target = "orderdetailsCollection")
    @Override
    Orders toEntity(final OrdersDTO ordersDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    Collection<Orders> toEntity(final Collection<OrdersDTO> ordersDTOs, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "orderdetailsCollection", target = "orderdetailsDTOCollection")
    @Override
    @InheritInverseConfiguration
    OrdersDTO toDataObject(final Orders orders, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    @InheritInverseConfiguration
    Collection<OrdersDTO> toDataObject(final Collection<Orders> orders, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    //  @Mapping(source = "libraryId", target = "library")
    /*
    default Orders fromOrderNumber(final Integer orderNumber) {
        if (orderNumber == null) {
            return null;
        }
        final Orders orders = new Orders();
        orders.setOrderNumber(orderNumber);
        return orders;
    }
     */
}
