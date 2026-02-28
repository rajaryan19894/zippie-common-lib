package com.googne.zippie.common.lib.validator;

import com.googne.zippie.common.lib.exception.BadRequestException;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public interface BaseValidator<T> extends Validator<T> {
    String MUST_NOT_BE_NULL = " must not be null";
    String CANNOT_BE_EMPTY = " cannot be empty";
    String CANNOT_BE_NULL_OR_EMPTY = " cannot be null or empty";

    default void requireNonNull(T object, String entityName) {
        if (object == null) {
            throw new IllegalArgumentException(entityName + MUST_NOT_BE_NULL);
        }
    }

    default void requireNonEmpty(String str, String entityName) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(entityName + CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    default void requireNonEmpty(Collection<?> collection, String entityName) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new IllegalArgumentException(entityName + CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    default void requireNonEmpty(Map<?, ?> map, String entityName) {
        if (Objects.isNull(map) || map.isEmpty()) {
            throw new IllegalArgumentException(entityName + CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    default <E> void validateFirstElement(Collection<E> collection,
                                          java.util.function.Predicate<E> predicate,
                                          String message) {
        requireNonEmpty(collection, "Collection");
        E first = collection.iterator().next();
        if (!predicate.test(first)) {
            throw new BadRequestException(message);
        }
    }

    default <E> void validateAllElements(Collection<E> collection,
                                         java.util.function.Predicate<E> predicate,
                                         String message) {
        requireNonEmpty(collection, "Collection");
        for (E element : collection) {
            if (!predicate.test(element)) {
                throw new BadRequestException(message);
            }
        }
    }

    default <E> void requireNonEmpty(E[] array, String entityName) {
        if (Objects.isNull(array) || array.length == 0) {
            throw new IllegalArgumentException(entityName + CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    default <E> void requireNonEmpty(Optional<E> optional, String entityName) {
        if (optional.isEmpty()) {
            throw new IllegalArgumentException(entityName + CANNOT_BE_EMPTY);
        }
    }
}

