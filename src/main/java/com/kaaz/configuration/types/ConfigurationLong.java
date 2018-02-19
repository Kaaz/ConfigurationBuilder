package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

public class ConfigurationLong implements IConfigurationParser<Long> {
    @Override
    public Long parse(String value) {
        return Long.parseLong(value);
    }
}
