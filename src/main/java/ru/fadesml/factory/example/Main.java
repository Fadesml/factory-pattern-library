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
        //ParentObject{name='Son'}
        //class ru.fadesml.factory.example.entity.SonObject
        System.out.println(familyFactory.createChildByKey("Son"));
        System.out.println(familyFactory.createChildByKey("Son").getClass());
        System.out.println("\n");

        //ParentObject{name='Son'}
        //class ru.fadesml.factory.example.entity.SonObject
        //ParentObject{name='Daughter'}
        //class ru.fadesml.factory.example.entity.DaughterObject
        familyFactory.createListOfAllDeclaredChildren().forEach(child -> System.out.println(child.toString() + "\n" + child.getClass()));
        System.out.println("\n");


        //ParentObject{name='Son'}
        //class ru.fadesml.factory.example.entity.SonObject
        //ParentObject{name='AdoptedSon'}
        //class ru.fadesml.factory.example.entity.AdoptedSonObject
        //ParentObject{name='Daughter'}
        //class ru.fadesml.factory.example.entity.DaughterObject
        familyFactory.createListOfAllChildren().forEach(child -> System.out.println(child.toString() + "\n" + child.getClass()));
    }
}

