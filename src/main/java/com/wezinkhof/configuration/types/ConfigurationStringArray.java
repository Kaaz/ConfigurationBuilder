package com.wezinkhof.configuration.types;

import com.wezinkhof.configuration.IConfigurationParser;

/**
 * splits the propertie on '#' into in array
 */
public class ConfigurationStringArray implements IConfigurationParser<String[]> {
    @Override
    public String[] parse(String value) {
        if (value != null) {
            return value.split("#");
        }
        return new String[0];
    }
}
