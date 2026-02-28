package com.googne.zippie.common.lib.mapper;

/*
 *
 * E → Entity
 * SE → SubEntity
 * REQ → Request DTO
 *
 */
public interface NestedMapper<E, REQ, SE> {
    E fromDTO(REQ request, SE subEntity);
}