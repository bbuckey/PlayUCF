package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import annotation.ModelMethodType;

/**
 * 
 * @author Benjamin Buckey
 *
 *	This annotation is used in a model method there are two values which are entered
 *  methodType which must be a enum from the class ModelMethodTye,  This field is not required 
 *  but is used to denote two types of methods ModelMethodTye.GET for getter methods and
 *  ModelMethodTye.SET for setter methods.  If the value is present then the jvm will know that the method is
 *  a getter or setter however if the value is not present the jvm will try to determine the method type on its own
 *  and execute the method accordingly.  The value viewFieldName should be the same value in the ModelField annotation
 *  as it is used for display and field to method matching.  The reason this field is present is so that getter and setter method names
 *  can deviate from the norm.  
 *  
 */

@Target(ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModelMethod {
	ModelMethodType methodType() default ModelMethodType.UNKNOWN;
	String viewFieldName();
}
