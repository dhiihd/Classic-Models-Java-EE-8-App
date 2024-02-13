package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.ProductsDTO;
import com.classicmodels.entity.Products;
import java.util.Collection;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {LibraryMapper.class})
@Mapper
public interface ProductsMapper extends EntityMapper<ProductsDTO, Products> {

    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    // @Mapping(source = "library.id", target = "libraryId")
       //  @Mapping(source = "libraryId", target = "library")
    @Mapping(source = "orderdetailsDTOCollection", target = "orderdetailsCollection")
    @Override
    Products toEntity(final ProductsDTO productsDTO, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Override
    Collection<Products> toEntity(final Collection<ProductsDTO> productsDTOs, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

     @Override
    @InheritInverseConfiguration
    ProductsDTO toDataObject(final Products products, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext); 

    @Override
    @InheritInverseConfiguration
    Collection<ProductsDTO> toDataObject(final Collection<Products> products, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);


    
    /*
    default Products fromProductCode(final String productCode) {
        if (productCode == null) {
            return null;
        }
        final Products products = new Products();
        products.setProductCode(productCode);
        return products;
    }
*/
}
