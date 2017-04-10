package com.kaaz.configuration;


import java.util.Comparator;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * Created on 30-8-2016
 */
public class ConfigurationProperties extends Properties {
    private static final long serialVersionUID = 1L;

    public Enumeration<Object> keys() {
        Enumeration<Object> keysEnum = super.keys();
        Vector<Object> keyList = new Vector<>();

        while (keysEnum.hasMoreElements()) {
            keyList.add(keysEnum.nextElement());
        }
        keyList.sort(Comparator.comparing(Object::toString));
        return keyList.elements();
    }
}