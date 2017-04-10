package com.kaaz.configuration;

/**
 * Created on 30-8-2016
 */
public interface IConfigurationParser<Type> {

    Type parse(String value);

    default String toStringValue(Object o) {
        return String.valueOf(o);
    }
}
