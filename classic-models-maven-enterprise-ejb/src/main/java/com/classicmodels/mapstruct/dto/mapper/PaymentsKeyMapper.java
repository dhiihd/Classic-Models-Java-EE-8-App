package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.PaymentsKeyDTO;
import com.classicmodels.entity.PaymentsPK;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {LibraryMapper.class})
@Mapper
public interface PaymentsKeyMapper extends EntityMapper<PaymentsKeyDTO, PaymentsPK> {

    PaymentsKeyMapper INSTANCE = Mappers.getMapper(PaymentsKeyMapper.class);

    // @Mapping(source = "library.id", target = "libraryId")
    //  @Mapping(source = "libraryId", target = "library")
    @Override
    @Mapping(source = "customerNumber", target = "customerNumber")
    @Mapping(source = "checkNumber", target = "checkNumber")
    PaymentsPK toEntity(final PaymentsKeyDTO paymentsKeyDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    Collection<PaymentsPK> toEntity(final Collection<PaymentsKeyDTO> paymentsKeyDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    @InheritInverseConfiguration
    PaymentsKeyDTO toDataObject(final PaymentsPK paymentsPK, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    @InheritInverseConfiguration
    Collection<PaymentsKeyDTO> toDataObject(final Collection<PaymentsPK> paymentsPK, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    /*
    
    default PaymentsPK fromCustomerNumber(final Integer customerNumber) {
        if (customerNumber == null) {
            return null;
        }
        final PaymentsPK paymentsPK = new PaymentsPK();
        paymentsPK.setCustomerNumber(customerNumber);
        return paymentsPK;
    }
     */
}
