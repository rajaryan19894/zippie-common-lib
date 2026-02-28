package com.googne.zippie.common.lib.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/*
 * E → Entity
 * REQ → Request DTO
 * */
public interface UpdateMapper<E, REQ> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(REQ request, @MappingTarget E entity);
}