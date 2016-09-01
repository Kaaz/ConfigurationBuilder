package com.wezinkhof.configuration.types;

import com.wezinkhof.configuration.IConfigurationParser;

/**
 * Created on 30-8-2016
 */
public class ConfigurationInteger implements IConfigurationParser<Integer> {
	@Override
	public Integer parse(String value) {
		return Integer.parseInt(value);
	}
}
