package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.OrderdetailsKeyDTO;
import com.classicmodels.entity.OrderdetailsPK;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {LibraryMapper.class})
@Mapper
public interface OrderdetailsKeyMapper extends EntityMapper<OrderdetailsKeyDTO, OrderdetailsPK> {
   
    
    OrderdetailsKeyMapper INSTANCE = Mappers.getMapper(OrderdetailsKeyMapper.class);
   // @Mapping(source = "library.id", target = "libraryId")
    
    
  //  @Mapping(source = "libraryId", target = "library")
    @Mapping(source = "orderNumber", target = "orderNumber")
    @Mapping(source = "productCode", target = "productCode")
    @Override
    OrderdetailsPK toEntity(final OrderdetailsKeyDTO orderdetailsKeyDTO,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @Override
    Collection<OrderdetailsPK> toEntity(final Collection<OrderdetailsKeyDTO> orderdetailsKeyDTO,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @Override
    @InheritInverseConfiguration
    OrderdetailsKeyDTO toDataObject(final OrderdetailsPK orderdetailsPK,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @Override
    @InheritInverseConfiguration
    Collection<OrderdetailsKeyDTO> toDataObject(final Collection<OrderdetailsPK> orderdetailsPK,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
   /*
    default OrderdetailsPK fromOrderNumber(final Integer orderNumber) {
        if (orderNumber == null) {
            return null;
        }
        final OrderdetailsPK orderdetailsPK = new OrderdetailsPK();
        orderdetailsPK.setOrderNumber(orderNumber);
        return orderdetailsPK;
    }
*/
}
