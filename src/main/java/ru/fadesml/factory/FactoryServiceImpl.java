package ru.fadesml.factory;

import org.reflections.Reflections;
import ru.fadesml.factory.annotations.FactoryObjectAnnotation;
import ru.fadesml.factory.exceptions.FactoryObjectNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class FactoryServiceImpl.
 *
 * @version 2.2
 * @autor Fadesml
 */

public class FactoryServiceImpl implements FactoryService {

    /** List of String with package which have your children classes */
    private final List<String> subObjectResourcePathList;

    /** Parent object class */
    private final Class<?> baseObjectClass;

    public FactoryServiceImpl(Class<?> baseObjectClass, String ... subObjectResourcePath) {
        this.baseObjectClass = baseObjectClass;
        this.subObjectResourcePathList = new ArrayList<String>() {{
            this.addAll(Arrays.asList(subObjectResourcePath));
        }};

    }

    /**
     * @param key
     * @return-type Object
     * @return One of the children object of your parent class, which key from @FactoryObjectAnnotation == parameter key,
     *      and founded in the subObjectResourcePathList packages.
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws FactoryObjectNotFoundException if an error throws, please check the @FactoryObjectAnnotation of your child classes,
     *      making sure to make unique annotation parameter key values for each of them
     */
    @Override
    public Object createChildByKey(String key) throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException {
        for (String path : subObjectResourcePathList) {
            for (Class<?> object : new Reflections(path).getSubTypesOf(baseObjectClass)) {
                try {
                    if (object.getAnnotation(FactoryObjectAnnotation.class).key().equals(key)) {
                        return object.newInstance();
                    }
                } catch (NullPointerException ignored) { }
            }
        }

        throw new FactoryObjectNotFoundException("How to avoid this exception, see in documentation. \n" +
                "See https://github.com/Fadesml/factory-pattern-library/");
    }

    /**
     * @return-type List of Object
     * @return List of all child objects of your parent class, founded in the subObjectResourcePathList packages.
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws FactoryObjectNotFoundException if an error occurs, please check your subObjectResourcePathList when you initialize FactoryService
     */
    @Override
    public List<Object> createListOfAllChildren() throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException {
        List<Object> result = new ArrayList<>();
        for (String path : subObjectResourcePathList) {
            for (Class<?> object : new Reflections(path).getSubTypesOf(baseObjectClass)) {
                result.add(object.newInstance());
            }
        }
        if (result.isEmpty()) {
            throw new FactoryObjectNotFoundException("How to avoid this exception, see in documentation. \n" +
                        "See https://github.com/Fadesml/factory-pattern-library/");
        }

        return result;
    }

    /**
     * @return-type List of Object
     * @return List of all child objects of your parent class which have FactoryObjectAnnotation, founded in the subObjectResourcePathList packages.
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws FactoryObjectNotFoundException if an error occurs, please check your subObjectResourcePathList when you initialize FactoryService
     */
    @Override
    public List<Object> createListOfAllDeclaredChildren() throws IllegalAccessException, InstantiationException, FactoryObjectNotFoundException {
        List<Object> result = new ArrayList<>();
        for (String path : subObjectResourcePathList) {
            for (Class<?> object : new Reflections(path).getSubTypesOf(baseObjectClass)) {
                try {
                    if (object.getAnnotation(FactoryObjectAnnotation.class) != null) {
                        result.add(object.newInstance());
                    }
                } catch (NullPointerException ignored) { }
            }
        }
        if (result.isEmpty()) {
            throw new FactoryObjectNotFoundException("How to avoid this exception, see in documentation. \n" +
                    "See https://github.com/Fadesml/factory-pattern-library/");
        }

        return result;
    }
}
