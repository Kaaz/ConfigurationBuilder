[![](https://jitpack.io/v/MaikWezinkhof/ConfigurationBuilder.svg)](https://jitpack.io/#MaikWezinkhof/ConfigurationBuilder)

# Configuration builder

A utility to make maintaining configuration files somewhat easier.

## Usage

Make a config class containing public static variables.  
Annotate them with the @ConfigurationOption.  
Call the build function to override them with the associated property file.

## Example

Make the config class containing variables with

```java
public class Config {

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
```

somewhere in the application

```java
public class Launcher{

	...
	public static main(String ... args){
		new ConfigurationBuilder(Config.class, new File("application.cfg")).build();
	}
}
```

will generate application.cfg containing:

```ini
i_am_enabled=false
max_amount=8
run_on_sunday=true
type_of_weather=sunny
welcome_text=Hello there
```

If we where to edit welcome_text like:
```ini
...
welcome_text=And his name is..
```

would result in..

```java
public class Launcher{

	...
	public static main(String ... args){
		System.out.println(Config.WELCOME_TEXT);
		//still prints: Hello there..
		new ConfigurationBuilder(Config.class, new File("application.cfg")).build();
		System.out.println(Config.WELCOME_TEXT);
		//prints: And his name is..
	}
}
```

