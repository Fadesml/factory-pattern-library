package ru.fadesml.factory.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FactoryObjectAnnotation {
    String key();
}
