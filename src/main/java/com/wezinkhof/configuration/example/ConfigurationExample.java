package com.wezinkhof.configuration.example;

import com.wezinkhof.configuration.ConfigurationOption;

public class ConfigurationExample {

	@ConfigurationOption
	public static boolean I_AM_ENABLED = false;

	@ConfigurationOption
	public static String WELCOME_TEXT = "Hello there";

	@ConfigurationOption
	public static int MAX_AMOUNT = 8;

	@ConfigurationOption
	public static boolean RUN_ON_SUNDAY = true;

	@ConfigurationOption
	public static String TYPE_OF_WEATHER = "sunny";
}
