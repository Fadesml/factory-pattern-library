package ru.fadesml.factory.example.entity;

import ru.fadesml.factory.annotations.FactoryObjectAnnotation;

/**
 * Class DaughterObject.
 *
 * @version 1.0
 * @autor Fadesml
 */

@FactoryObjectAnnotation
public class DaughterObject extends ParentObject {
    public DaughterObject() {
        this.setName("Daughter");
    }
}
