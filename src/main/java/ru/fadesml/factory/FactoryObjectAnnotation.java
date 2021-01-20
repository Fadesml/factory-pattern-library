package ru.fadesml.factory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FactoryObjectAnnotation {
    String factory();
    String name();
}
