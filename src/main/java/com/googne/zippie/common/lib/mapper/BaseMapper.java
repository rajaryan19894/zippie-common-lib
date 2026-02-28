package com.googne.zippie.common.lib.mapper;

import org.mapstruct.BeanMapping;

import java.util.List;

/*
 *
 * E → Entity
 * REQ → Request DTO
 * RES → Response DTO
 *
 */
public interface BaseMapper<E, REQ, RES> {
    @BeanMapping(ignoreByDefault = false)
    RES toDTO(E entity);

    List<RES> toDTO(List<E> entities);

    E fromDTO(REQ request);

    List<E> fromDTO(List<REQ> request);
}