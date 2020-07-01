package com.kf2y.tcool.service.exception;

public class ElementNotFoundException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs the exception with the necessary infos
     *
     * @param entity
     *            the entity class
     * @param id
     *            the id
     */
    public ElementNotFoundException(final Class<?> entity, final Long id) {
        super(String.format("Cannot find entity of class [%s] with id [%d]", entity.getName(), id));
    }
}
