package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.PaymentsKeyDTO;
import com.classicmodels.entity.PaymentsPK;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:33+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class PaymentsKeyMapperImpl implements PaymentsKeyMapper {

    @Override
    public PaymentsPK toEntity(PaymentsKeyDTO paymentsKeyDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        PaymentsPK target = cycleAvoidingMappingContext.getMappedInstance( paymentsKeyDTO, PaymentsPK.class );
        if ( target != null ) {
            return target;
        }

        if ( paymentsKeyDTO == null ) {
            return null;
        }

        PaymentsPK paymentsPK = new PaymentsPK();

        cycleAvoidingMappingContext.storeMappedInstance( paymentsKeyDTO, paymentsPK );

        paymentsPK.setCustomerNumber( paymentsKeyDTO.getCustomerNumber() );
        paymentsPK.setCheckNumber( paymentsKeyDTO.getCheckNumber() );

        return paymentsPK;
    }

    @Override
    public Collection<PaymentsPK> toEntity(Collection<PaymentsKeyDTO> paymentsKeyDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<PaymentsPK> target = cycleAvoidingMappingContext.getMappedInstance( paymentsKeyDTO, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( paymentsKeyDTO == null ) {
            return null;
        }

        Collection<PaymentsPK> collection = new ArrayList<PaymentsPK>( paymentsKeyDTO.size() );
        cycleAvoidingMappingContext.storeMappedInstance( paymentsKeyDTO, collection );

        for ( PaymentsKeyDTO paymentsKeyDTO1 : paymentsKeyDTO ) {
            collection.add( toEntity( paymentsKeyDTO1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public PaymentsKeyDTO toDataObject(PaymentsPK paymentsPK, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        PaymentsKeyDTO target = cycleAvoidingMappingContext.getMappedInstance( paymentsPK, PaymentsKeyDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( paymentsPK == null ) {
            return null;
        }

        PaymentsKeyDTO paymentsKeyDTO = new PaymentsKeyDTO();

        cycleAvoidingMappingContext.storeMappedInstance( paymentsPK, paymentsKeyDTO );

        paymentsKeyDTO.setCustomerNumber( paymentsPK.getCustomerNumber() );
        paymentsKeyDTO.setCheckNumber( paymentsPK.getCheckNumber() );

        return paymentsKeyDTO;
    }

    @Override
    public Collection<PaymentsKeyDTO> toDataObject(Collection<PaymentsPK> paymentsPK, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<PaymentsKeyDTO> target = cycleAvoidingMappingContext.getMappedInstance( paymentsPK, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( paymentsPK == null ) {
            return null;
        }

        Collection<PaymentsKeyDTO> collection = new ArrayList<PaymentsKeyDTO>( paymentsPK.size() );
        cycleAvoidingMappingContext.storeMappedInstance( paymentsPK, collection );

        for ( PaymentsPK paymentsPK1 : paymentsPK ) {
            collection.add( toDataObject( paymentsPK1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }
}
