package ru.fadesml.factory.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation FactoryObjectAnnotation
 *
 * @version 1.2
 * @autor Fadesml
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FactoryObjectAnnotation {
    String key() default "";
}
