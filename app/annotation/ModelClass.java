package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

/**
 * 
 * @author Benjamin Buckey
 *
 *	This annotation is placed at the class level of a model this will tell the jvm that 
 *  this class is a model of an object and it is used with ModelField and ModelMethod 
 *  as long as these annotations are present and the ViewClass annotation is present in the view 
 *  the values will be dynamically set using java reflection
 *  
 */
@Target(ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModelClass {

}
