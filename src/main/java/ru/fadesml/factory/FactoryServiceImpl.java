package ru.fadesml.factory;

import org.reflections.Reflections;

/**
 * Class CoffeeService.
 *
 * @version 1.0
 * @autor Fadesml
 */

public class FactoryServiceImpl implements FactoryService {
    private final String subObjectResourcePath;
    private final Class<?> baseObjectClass;

    public FactoryServiceImpl(String subObjectResourcePath, Class<?> baseObjectClass) {
        this.subObjectResourcePath = subObjectResourcePath;
        this.baseObjectClass = baseObjectClass;
    }

    @Override
    public Object create(String factory, String name) throws IllegalAccessException, InstantiationException {
        for (Class<?> object : new Reflections(subObjectResourcePath).getSubTypesOf(baseObjectClass)) {
            FactoryObjectAnnotation objectFactoryAnnotation = object.getAnnotation(FactoryObjectAnnotation.class);
            if (objectFactoryAnnotation.factory().equals(factory)) {
                if (object.getAnnotation(FactoryObjectAnnotation.class).name().equals(name)) {
                    return object.newInstance();
                }
            }
        }
        return baseObjectClass.newInstance();
    }
}
