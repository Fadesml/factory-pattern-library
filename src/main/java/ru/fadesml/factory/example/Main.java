package ru.fadesml.factory.example;

import ru.fadesml.factory.FactoryService;
import ru.fadesml.factory.FactoryServiceImpl;
import ru.fadesml.factory.example.entity.ParentObject;
import ru.fadesml.factory.exceptions.FactoryObjectNotFoundException;

/**
 * Class Main.
 *
 * @version 1.0
 * @autor Fadesml
 */

public class Main {
    private static final FactoryService familyFactory = new FactoryServiceImpl(ParentObject.class, "ru.fadesml.factory.example.entity");

    public static void main(String[] args) throws IllegalAccessException, FactoryObjectNotFoundException, InstantiationException {
        //printed ParentObject{name='Son'}
        System.out.println(familyFactory.createChildByKey("Son"));

        //printed [ParentObject{name='Son'}, ParentObject{name='Daughter'}]
        System.out.println(familyFactory.createListOfAllDeclaredChildren());

        //printed [ParentObject{name='Son'}, ParentObject{name='AdoptedSon'}, ParentObject{name='Daughter'}]
        System.out.println(familyFactory.createListOfAllChildren());
    }
}
