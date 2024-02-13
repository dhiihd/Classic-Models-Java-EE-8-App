package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.OrderdetailsKeyDTO;
import com.classicmodels.entity.OrderdetailsPK;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:33+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class OrderdetailsKeyMapperImpl implements OrderdetailsKeyMapper {

    @Override
    public OrderdetailsPK toEntity(OrderdetailsKeyDTO orderdetailsKeyDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        OrderdetailsPK target = cycleAvoidingMappingContext.getMappedInstance( orderdetailsKeyDTO, OrderdetailsPK.class );
        if ( target != null ) {
            return target;
        }

        if ( orderdetailsKeyDTO == null ) {
            return null;
        }

        OrderdetailsPK orderdetailsPK = new OrderdetailsPK();

        cycleAvoidingMappingContext.storeMappedInstance( orderdetailsKeyDTO, orderdetailsPK );

        orderdetailsPK.setOrderNumber( orderdetailsKeyDTO.getOrderNumber() );
        orderdetailsPK.setProductCode( orderdetailsKeyDTO.getProductCode() );

        return orderdetailsPK;
    }

    @Override
    public Collection<OrderdetailsPK> toEntity(Collection<OrderdetailsKeyDTO> orderdetailsKeyDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<OrderdetailsPK> target = cycleAvoidingMappingContext.getMappedInstance( orderdetailsKeyDTO, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( orderdetailsKeyDTO == null ) {
            return null;
        }

        Collection<OrderdetailsPK> collection = new ArrayList<OrderdetailsPK>( orderdetailsKeyDTO.size() );
        cycleAvoidingMappingContext.storeMappedInstance( orderdetailsKeyDTO, collection );

        for ( OrderdetailsKeyDTO orderdetailsKeyDTO1 : orderdetailsKeyDTO ) {
            collection.add( toEntity( orderdetailsKeyDTO1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public OrderdetailsKeyDTO toDataObject(OrderdetailsPK orderdetailsPK, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        OrderdetailsKeyDTO target = cycleAvoidingMappingContext.getMappedInstance( orderdetailsPK, OrderdetailsKeyDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( orderdetailsPK == null ) {
            return null;
        }

        OrderdetailsKeyDTO orderdetailsKeyDTO = new OrderdetailsKeyDTO();

        cycleAvoidingMappingContext.storeMappedInstance( orderdetailsPK, orderdetailsKeyDTO );

        orderdetailsKeyDTO.setOrderNumber( orderdetailsPK.getOrderNumber() );
        orderdetailsKeyDTO.setProductCode( orderdetailsPK.getProductCode() );

        return orderdetailsKeyDTO;
    }

    @Override
    public Collection<OrderdetailsKeyDTO> toDataObject(Collection<OrderdetailsPK> orderdetailsPK, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<OrderdetailsKeyDTO> target = cycleAvoidingMappingContext.getMappedInstance( orderdetailsPK, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( orderdetailsPK == null ) {
            return null;
        }

        Collection<OrderdetailsKeyDTO> collection = new ArrayList<OrderdetailsKeyDTO>( orderdetailsPK.size() );
        cycleAvoidingMappingContext.storeMappedInstance( orderdetailsPK, collection );

        for ( OrderdetailsPK orderdetailsPK1 : orderdetailsPK ) {
            collection.add( toDataObject( orderdetailsPK1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }
}
