package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

public class ConfigurationBoolean implements IConfigurationParser<Boolean> {
    @Override
    public Boolean parse(String value) {
        return Boolean.parseBoolean(value);
    }
}
