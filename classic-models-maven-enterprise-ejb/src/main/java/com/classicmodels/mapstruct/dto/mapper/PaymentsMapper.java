package com.classicmodels.mapstruct.dto.mapper;


import com.classicmodels.dto.PaymentsDTO;
import com.classicmodels.entity.Payments;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


//@Mapper(componentModel = "spring", uses = {BookMapper.class})

/**
 *
 * @author dhiihd
 */
@Mapper
public interface PaymentsMapper extends EntityMapper<PaymentsDTO, Payments> {
    
    PaymentsMapper INSTANCE = Mappers.getMapper(PaymentsMapper.class );  
    
    // @Mapping(source = "library.id", target = "libraryId")
   
  //  @Mapping(source = "libraryId", target = "library")
   
 //   @Mapping(source = "paymentsKeyDTO", target = "paymentsPK" )
    @Override
    Payments toEntity(final PaymentsDTO paymentsDTO,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    Collection<Payments> toEntity(final Collection<PaymentsDTO> paymentsDTOs,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    
    @Override
            @InheritInverseConfiguration
    PaymentsDTO toDataObject(final Payments payments,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @InheritInverseConfiguration
    @Override
    Collection<PaymentsDTO> toDataObject(final Collection<Payments> payments,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
   /*
    default Payments fromPaymentsPK(final PaymentsPK paymentsPK) {
        if (paymentsPK == null) {
            return null;
        }
        final Payments payments = new Payments();
        payments.setPaymentsPK(paymentsPK);
        return payments;
    }
    */
}
