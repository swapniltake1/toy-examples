package org.example;

import java.util.Locale;
import java.util.NoSuchElementException;

import textops.LocaleParser;

public class HelloWorld {

    // TODO: Write tests first, don't use external API to get tests to pass
    static String greeting(Locale locale) {
        return "NOT IMPLEMENTED YET";
    }

    public static void main(String[] args) {
        boolean responded = false;
        for (String arg : args) {
            try {
                Locale locale = LocaleParser.parse(arg);
                System.out.println(greeting(locale));
                responded = true;
            } catch (NoSuchElementException nsee) {
                System.err.println(nsee.getMessage());
            }
        }
        if (!responded) {
            System.out.println("Hello, world!");
        }
    }

}
