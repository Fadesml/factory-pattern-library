package ru.fadesml.factory;

import ru.fadesml.factory.exceptions.FactoryObjectNotFoundException;

import java.util.List;

/**
 * Interface FactoryService.
 *
 * @version 1.0
 * @autor Fadesml
 */

public interface FactoryService {
    Object create(String key) throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException;
    List<Object> createAll() throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException;
}
