package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

public class ConfigurationInteger implements IConfigurationParser<Integer> {
    @Override
    public Integer parse(String value) {
        return Integer.parseInt(value);
    }
}
