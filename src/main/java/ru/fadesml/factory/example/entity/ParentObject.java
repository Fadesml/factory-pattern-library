package ru.fadesml.factory.example.entity;

/**
 * Class ParentObject.
 *
 * @version 1.0
 * @autor Fadesml
 */

public class ParentObject {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ParentObject() {
        this.name = "Parent";
    }

    @Override
    public String toString() {
        return "ParentObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
