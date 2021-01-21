# Factory Pattern Library
Realisation for fast creating and using pattern - "Factory"
____

## Required dependencies
### For maven projects
```xml
<dependencies>

  <!-- https://mvnrepository.com/artifact/org.reflections/reflections -->
  <dependency>
      <groupId>org.reflections</groupId>
      <artifactId>reflections</artifactId>
      <version>0.9.11</version>
  </dependency>
  
</dependencies>
```

### For gradle projects
```gradle
dependencies {

    // https://mvnrepository.com/artifact/org.reflections/reflections
    compile group: 'org.reflections', name: 'reflections', version: '0.9.11'
    
}
```
____

## Documentation
Please read the documentation carefully before using the library and swearing at errors, and also see the example, the link to which is at the end of the documentation.
____
### Annotations
#### *@FactoryObjectAnnotation*
| Parameter | Type | Purpose |
|:----------------:|:---------:|:----------------:|
| *key* | *String* | Specify the name of the object for further creation of this object produced by the factory of the parent class |
##### Description
Use this annotation for child classes derived from your factory.
____

### Services
#### *FactoryServiceImpl*
##### Parameters
| Parameter | Type | Purpose |
|:----------------:|:---------:|:----------------:|
| *subObjectResourcePathList* | *List<String>* | List of paths that have child classes derived from your parent classes |
| *baseObjectClass* | *Class<?>* | The parent class of your future factory |
##### Methods
###### *createChildByKey*
| Parameter | Type | Purpose |
|:----------------:|:---------:|:----------------:|
| *key* | *String* | Child object key from *@FactoryObjectAnnotation* in your child class |

throws - IllegalAccessException, InstantiationException, FactoryObjectNotFoundException  
return type - Object  
returns One of the children object of your parent class, which key from *@FactoryObjectAnnotation* == parameter *key*, and founded in the *subObjectResourcePathList* packages.

###### *createListOfAllChildren*
throws - IllegalAccessException, InstantiationException, FactoryObjectNotFoundException  
return type - List of Object  
returns List of all child objects of your parent class, founded in the *subObjectResourcePathList* packages.

###### *createListOfAllDeclaredChildren*
throws - IllegalAccessException, InstantiationException, FactoryObjectNotFoundException  
return type - List of Object  
returns List of all child objects of your parent class which have FactoryObjectAnnotation, founded in the subObjectResourcePathList packages.
____

### Exceptions
#### *FactoryObjectNotFoundException*
How to avoid this exception:
1. If an error occurs when using the *createChildByKey()* method, please check the @FactoryObjectAnnotation of your child classes, making sure to make unique annotation parameter *key* values for each of them
2. If an error occurs when using the *createListOfAllChildren()* or *createListOfAllDeclaredChildren()* method, please check your *subObjectResourcePathList* when initializing *FactoryService* or check your
3. If an error occurs when using the *createListOfAllDeclaredChildren()* method, please check the @FactoryObjectAnnotation of your child classes, maybe it doesn't exist

____
### Example
An example of implementing the factory pattern using this library can be found here - https://github.com/Fadesml/factory-pattern-library/tree/master/src/main/java/ru/fadesml/factory/example