package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.ProductlinesDTO;
import com.classicmodels.entity.Productlines;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


//@Mapper(uses = {LibraryMapper.class})
@Mapper
public interface ProductlinesMapper extends EntityMapper<ProductlinesDTO, Productlines> {
    
    ProductlinesMapper INSTANCE = Mappers.getMapper(ProductlinesMapper.class );    
    
// @Mapping(source = "library.id", target = "libraryId")
 //   @Mapping(source = "orderdetailsCollection", target = "orderdetailsDTOCollection")
    
  //  @Mapping(source = "libraryId", target = "library")
   
  //  @Mapping(source = "orderdetailsDTOCollection", target = "orderdetailsCollection")
    @Override
 //   @Mapping(source = "productlinesDTO", target = "productline")
    Productlines toEntity(final ProductlinesDTO productlinesDTO,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @Override
    Collection<Productlines> toEntity(final Collection<ProductlinesDTO> productlinesDTOs,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @Override
           
            @InheritInverseConfiguration
    ProductlinesDTO toDataObject(final Productlines productlines,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    @Override
            @InheritInverseConfiguration
    Collection<ProductlinesDTO> toDataObject(final Collection<Productlines> productlines,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    /*
    default Productlines fromProductLine(final String productLine) {
        if (productLine == null) {
            return null;
        }
        final Productlines productlines = new Productlines();
        productlines.setProductLine(productLine);
        return productlines;
    }
*/
}
