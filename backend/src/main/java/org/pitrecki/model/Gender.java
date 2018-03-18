package org.pitrecki.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
public enum Gender
{
    MALE, FEMALE;

    @Override
    @JsonValue
    public String toString() {
        return super.toString().toLowerCase();
    }
}
