package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

public class ConfigurationString implements IConfigurationParser<String> {
    @Override
    public String parse(String value) {
        return value;
    }
}
