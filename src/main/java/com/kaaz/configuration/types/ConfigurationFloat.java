package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

public class ConfigurationFloat implements IConfigurationParser<Float> {
    @Override
    public Float parse(String value) {
        return Float.parseFloat(value);
    }
}
