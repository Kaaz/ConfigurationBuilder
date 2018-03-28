package com.kaaz.configuration;

public interface IConfigurationParser<Type> {

    Type parse(String value);

    default String toStringValue(Object o) {
        return String.valueOf(o);
    }
}
