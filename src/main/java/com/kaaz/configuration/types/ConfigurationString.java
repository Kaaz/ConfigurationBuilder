package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

/**
 * Created on 30-8-2016
 */
public class ConfigurationString implements IConfigurationParser<String> {
    @Override
    public String parse(String value) {
        return value;
    }
}
