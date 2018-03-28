package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

public class ConfigurationDouble implements IConfigurationParser<Double> {
    @Override
    public Double parse(String value) {
        return Double.parseDouble(value);
    }
}
