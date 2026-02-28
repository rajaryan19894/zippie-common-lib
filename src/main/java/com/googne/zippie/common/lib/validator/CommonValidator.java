package com.googne.zippie.common.lib.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommonValidator implements BaseValidator<Object> {
    @Override
    public void validate(Object object) {
        requireNonNull(object);
    }

    public void requireNonNull(Object object) {
        requireNonNull(object, "Object");
    }

    public void requireNonEmpty(String str) {
        requireNonEmpty(str, "String");
    }

    public void requireNonEmpty(Collection<?> collection) {
        requireNonEmpty(collection, "Collection");
    }

    public void requireNonEmpty(Map<?, ?> map) {
        requireNonEmpty(map, "Map");
    }

}
