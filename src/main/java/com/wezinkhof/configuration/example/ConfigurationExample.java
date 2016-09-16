package com.wezinkhof.configuration.example;

import com.wezinkhof.configuration.ConfigurationBuilder;
import com.wezinkhof.configuration.ConfigurationOption;

import java.io.File;

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

	public static void test() throws Exception {
		System.out.println("a configuration example");
		new ConfigurationBuilder(ConfigurationExample.class, new File("application.cfg")).build();
		System.out.println("ConfigurationExample.I_AM_ENABLED = " + ConfigurationExample.I_AM_ENABLED);
		System.out.println("ConfigurationExample.WELCOME_TEXT = " + ConfigurationExample.WELCOME_TEXT);
		System.out.println("ConfigurationExample.MAX_AMOUNT   = " + ConfigurationExample.MAX_AMOUNT);
	}
}
