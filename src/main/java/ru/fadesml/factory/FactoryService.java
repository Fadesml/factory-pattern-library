package ru.fadesml.factory;

/**
 * Interface CoffeService.
 *
 * @version 1.0
 * @autor Fadesml
 */

public interface FactoryService {
    Object create(String factory, String name) throws IllegalAccessException, InstantiationException;
}
