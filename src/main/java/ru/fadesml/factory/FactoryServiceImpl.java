package ru.fadesml.factory;

import org.reflections.Reflections;
import ru.fadesml.factory.annotations.FactoryObjectAnnotation;
import ru.fadesml.factory.exceptions.FactoryObjectNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class CoffeeService.
 *
 * @version 1.0
 * @autor Fadesml
 */

public class FactoryServiceImpl implements FactoryService {
    private final List<String> subObjectResourcePathList;
    private final Class<?> baseObjectClass;

    public FactoryServiceImpl(Class<?> baseObjectClass, String ... subObjectResourcePath) {
        this.baseObjectClass = baseObjectClass;
        this.subObjectResourcePathList = new ArrayList<String>() {{
            this.addAll(Arrays.asList(subObjectResourcePath));
        }};

    }

    @Override
    public Object create(String key) throws IllegalAccessException, InstantiationException {
        for (String path : subObjectResourcePathList) {
            for (Class<?> object : new Reflections(path).getSubTypesOf(baseObjectClass)) {
                try {
                    if (object.getAnnotation(FactoryObjectAnnotation.class).key().equals(key)) {
                        return object.newInstance();
                    }
                } catch (NullPointerException ignored) { }
            }
        }
        try {
            throw new FactoryObjectNotFoundException("Factory can't find and create non-existent object");
        } catch (FactoryObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> createAll() throws IllegalAccessException, InstantiationException {
        List<Object> result = new ArrayList<>();
        for (String path : subObjectResourcePathList) {
            for (Class<?> object : new Reflections(path).getSubTypesOf(baseObjectClass)) {
                result.add(object.newInstance());
            }
        }
        if (result.isEmpty()) {
            try {
                throw new FactoryObjectNotFoundException("How to avoid this exception, see in documentation. \n" +
                        "See https://github.com/Fadesml/factory-pattern-library/");
            } catch (FactoryObjectNotFoundException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
