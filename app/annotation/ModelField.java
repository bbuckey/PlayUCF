package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

/**
 *  This annotation is used at the field/member level of a model class 
 *	it will be used as the display name of the field in a view which 
 *  is entered as a string in the viewFieldName field 
 *  alternateFieldName is used as a Secondary matching value in cases when 
 *  you use a different id i.e. You want want a formal name for the view but a backing 
 *  database column has a truncated field name 
 *  Please see com.ew3.annotaion.ModelClass
 *  com.ew3.annotation.ViewClass and com.ew3.annoation.ModelMethod
 * @author Benjamin Buckey
 */
@Target(ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModelField {
	String viewFieldName();
	String alternateFieldName() default "";
	int viewCol() default 0;
}
