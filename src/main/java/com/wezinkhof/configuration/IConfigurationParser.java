package com.wezinkhof.configuration;

/**
 * Created on 30-8-2016
 */
public interface IConfigurationParser<Type> {

    Type parse(String value);
}
