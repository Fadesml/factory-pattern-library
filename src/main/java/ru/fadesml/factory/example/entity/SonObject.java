package ru.fadesml.factory.example.entity;

import ru.fadesml.factory.annotations.FactoryObjectAnnotation;

/**
 * Class SonObject.
 *
 * @version 1.0
 * @autor Fadesml
 */

@FactoryObjectAnnotation(key = "Son")
public class SonObject extends ParentObject {
    public SonObject() {
        this.setName("Son");
    }
}
