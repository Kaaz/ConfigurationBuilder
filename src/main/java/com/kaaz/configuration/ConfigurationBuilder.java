package com.kaaz.configuration;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ClasspathHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigurationBuilder {
    private final File configFile;
    private final ConfigurationProperties properties;
    private final Class configclass;
    private final Map<Class<?>, IConfigurationParser> configurationParsers = new HashMap<>();

    public ConfigurationBuilder(Class configclass, File configFile) {
        this.configFile = configFile;
        this.configclass = configclass;
        this.properties = new ConfigurationProperties();
        loadParsers();
    }

    /**
     * loads the configuration parsers for each type
     */
    private void loadParsers() {
        Reflections reflections = new Reflections("com.kaaz.configuration.types");
        Set<Class<? extends IConfigurationParser>> classes = reflections.getSubTypesOf(IConfigurationParser.class);
        for (Class<? extends IConfigurationParser> parserclass : classes) {
            try {
                Class<?> parserType = (Class<?>) ((ParameterizedType) parserclass.getGenericInterfaces()[0]).getActualTypeArguments()[0];
                IConfigurationParser parserInstance = parserclass.getConstructor().newInstance();
                configurationParsers.put(parserType, parserInstance);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Updates the configClass's variables with the configFile's values
     *
     * @param cleanfile clear the File of all undefined variables
     * @throws IOException
     */
    public void build(Boolean cleanfile) throws Exception {
        if (configFile == null) throw new IllegalStateException("File not initialized");
        Reflections reflections = new Reflections(new org.reflections.util.ConfigurationBuilder()
                .setUrls(ClasspathHelper.forClass(configclass))
                .addScanners(new FieldAnnotationsScanner()));
        Set<Field> options = reflections.getFieldsAnnotatedWith(ConfigurationOption.class);
        if (configFile.exists()) {
            properties.load(new FileInputStream(configFile));
        }
        ConfigurationProperties cleanProperties = new ConfigurationProperties();

        options.forEach(o -> {
            ConfigurationOption option = o.getAnnotation(ConfigurationOption.class);
            try {
                String variableName = o.getName().toLowerCase();
                Object defaultValue = o.get(null);
                Object value = configFile.exists() ? properties.getOrDefault(variableName, defaultValue) : defaultValue;
                if (configurationParsers.containsKey(defaultValue.getClass())) {
                    o.setAccessible(true);
                    o.set(null, configurationParsers.get(defaultValue.getClass()).parse(String.valueOf(value)));
                    properties.setProperty(variableName, configurationParsers.get(defaultValue.getClass()).toStringValue(o.get(null)));
                    cleanProperties.setProperty(variableName, properties.getProperty(variableName));
                } else {
                    throw new Exception("Unknown Configuration Type");
                }
            } catch (IllegalAccessException e) {
                System.out.println("Could not load configuration, IllegalAccessException");
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        if (cleanfile) {
            cleanProperties.store(new FileOutputStream(configFile), null);
        } else {
            properties.store(new FileOutputStream(configFile), null);
        }
    }
}
