package com.wezinkhof.configuration.types;

import com.wezinkhof.configuration.IConfigurationParser;

/**
 * Created on 30-8-2016
 */
public class ConfigurationFloat implements IConfigurationParser<Float> {
    @Override
    public Float parse(String value) {
        return Float.parseFloat(value);
    }
}
