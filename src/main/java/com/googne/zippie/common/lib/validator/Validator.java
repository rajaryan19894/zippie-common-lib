package com.googne.zippie.common.lib.validator;

public interface Validator<T> {
    /**
     * Validate the given object according to some rules.
     *
     * @param object the object to validate
     * @throws RuntimeException or BusinessException if invalid
     */
    void validate(T object);
}
