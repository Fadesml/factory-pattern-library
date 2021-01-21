package ru.fadesml.factory;

import ru.fadesml.factory.exceptions.FactoryObjectNotFoundException;

import java.util.List;

/**
 * Interface FactoryService.
 *
 * @version 1.2
 * @autor Fadesml
 */

public interface FactoryService {
    Object createChildByKey(String key) throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException;
    List<Object> createListOfAllChildren() throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException;
    List<Object> createListOfAllDeclaredChildren() throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException;
}
