package com.kaaz.configuration.types;

import com.kaaz.configuration.IConfigurationParser;

/**
 * Created on 30-8-2016
 */
public class ConfigurationDouble implements IConfigurationParser<Double> {
    @Override
    public Double parse(String value) {
        return Double.parseDouble(value);
    }
}
