package com.classicmodels.mapstruct.dto.mapper;

import com.classicmodels.dto.ProductlinesDTO;
import com.classicmodels.dto.ProductsDTO;
import com.classicmodels.entity.Productlines;
import com.classicmodels.entity.Products;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-11T11:14:32+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (BellSoft)"
)
public class ProductlinesMapperImpl implements ProductlinesMapper {

    @Override
    public Productlines toEntity(ProductlinesDTO productlinesDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Productlines target = cycleAvoidingMappingContext.getMappedInstance( productlinesDTO, Productlines.class );
        if ( target != null ) {
            return target;
        }

        if ( productlinesDTO == null ) {
            return null;
        }

        Productlines productlines = new Productlines();

        cycleAvoidingMappingContext.storeMappedInstance( productlinesDTO, productlines );

        productlines.setProductLine( productlinesDTO.getProductLine() );
        productlines.setTextDescription( productlinesDTO.getTextDescription() );
        productlines.setHtmlDescription( productlinesDTO.getHtmlDescription() );
        byte[] image = productlinesDTO.getImage();
        if ( image != null ) {
            productlines.setImage( Arrays.copyOf( image, image.length ) );
        }
        productlines.setProductsCollection( productsDTOCollectionToProductsCollection( productlinesDTO.getProductsCollection(), cycleAvoidingMappingContext ) );

        return productlines;
    }

    @Override
    public Collection<Productlines> toEntity(Collection<ProductlinesDTO> productlinesDTOs, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Productlines> target = cycleAvoidingMappingContext.getMappedInstance( productlinesDTOs, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( productlinesDTOs == null ) {
            return null;
        }

        Collection<Productlines> collection = new ArrayList<Productlines>( productlinesDTOs.size() );
        cycleAvoidingMappingContext.storeMappedInstance( productlinesDTOs, collection );

        for ( ProductlinesDTO productlinesDTO : productlinesDTOs ) {
            collection.add( toEntity( productlinesDTO, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    @Override
    public ProductlinesDTO toDataObject(Productlines productlines, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        ProductlinesDTO target = cycleAvoidingMappingContext.getMappedInstance( productlines, ProductlinesDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( productlines == null ) {
            return null;
        }

        ProductlinesDTO productlinesDTO = new ProductlinesDTO();

        cycleAvoidingMappingContext.storeMappedInstance( productlines, productlinesDTO );

        productlinesDTO.setProductLine( productlines.getProductLine() );
        productlinesDTO.setTextDescription( productlines.getTextDescription() );
        productlinesDTO.setHtmlDescription( productlines.getHtmlDescription() );
        byte[] image = productlines.getImage();
        if ( image != null ) {
            productlinesDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        productlinesDTO.setProductsCollection( productsCollectionToProductsDTOCollection( productlines.getProductsCollection(), cycleAvoidingMappingContext ) );

        return productlinesDTO;
    }

    @Override
    public Collection<ProductlinesDTO> toDataObject(Collection<Productlines> productlines, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<ProductlinesDTO> target = cycleAvoidingMappingContext.getMappedInstance( productlines, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( productlines == null ) {
            return null;
        }

        Collection<ProductlinesDTO> collection = new ArrayList<ProductlinesDTO>( productlines.size() );
        cycleAvoidingMappingContext.storeMappedInstance( productlines, collection );

        for ( Productlines productlines1 : productlines ) {
            collection.add( toDataObject( productlines1, cycleAvoidingMappingContext ) );
        }

        return collection;
    }

    protected Products productsDTOToProducts(ProductsDTO productsDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Products target = cycleAvoidingMappingContext.getMappedInstance( productsDTO, Products.class );
        if ( target != null ) {
            return target;
        }

        if ( productsDTO == null ) {
            return null;
        }

        Products products = new Products();

        cycleAvoidingMappingContext.storeMappedInstance( productsDTO, products );

        products.setProductCode( productsDTO.getProductCode() );
        products.setProductName( productsDTO.getProductName() );
        products.setProductScale( productsDTO.getProductScale() );
        products.setProductVendor( productsDTO.getProductVendor() );
        products.setProductDescription( productsDTO.getProductDescription() );
        products.setQuantityInStock( productsDTO.getQuantityInStock() );
        products.setBuyPrice( productsDTO.getBuyPrice() );
        products.setMsrp( productsDTO.getMsrp() );

        return products;
    }

    protected Collection<Products> productsDTOCollectionToProductsCollection(Collection<ProductsDTO> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Products> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<Products> collection1 = new ArrayList<Products>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( ProductsDTO productsDTO : collection ) {
            collection1.add( productsDTOToProducts( productsDTO, cycleAvoidingMappingContext ) );
        }

        return collection1;
    }

    protected ProductsDTO productsToProductsDTO(Products products, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        ProductsDTO target = cycleAvoidingMappingContext.getMappedInstance( products, ProductsDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( products == null ) {
            return null;
        }

        ProductsDTO productsDTO = new ProductsDTO();

        cycleAvoidingMappingContext.storeMappedInstance( products, productsDTO );

        productsDTO.setProductCode( products.getProductCode() );
        productsDTO.setProductName( products.getProductName() );
        productsDTO.setProductScale( products.getProductScale() );
        productsDTO.setProductVendor( products.getProductVendor() );
        productsDTO.setProductDescription( products.getProductDescription() );
        productsDTO.setQuantityInStock( products.getQuantityInStock() );
        productsDTO.setBuyPrice( products.getBuyPrice() );
        productsDTO.setMsrp( products.getMsrp() );

        return productsDTO;
    }

    protected Collection<ProductsDTO> productsCollectionToProductsDTOCollection(Collection<Products> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<ProductsDTO> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<ProductsDTO> collection1 = new ArrayList<ProductsDTO>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( Products products : collection ) {
            collection1.add( productsToProductsDTO( products, cycleAvoidingMappingContext ) );
        }

        return collection1;
    }
}
