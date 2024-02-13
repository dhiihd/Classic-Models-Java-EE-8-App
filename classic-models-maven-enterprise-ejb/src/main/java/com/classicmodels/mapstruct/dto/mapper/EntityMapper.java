package com.classicmodels.mapstruct.dto.mapper;

import java.util.Collection;
import java.util.List;
import org.mapstruct.Context;

public interface EntityMapper<D, E> {

  
    D toDataObject(E entity,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    E toEntity(D data,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    Collection<D> toDataObject(Collection<E> entityCollection,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
    Collection<E> toEntity(Collection<D> dataCollection,@Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    
}
