package io.katharsis.repository.annotations;

import io.katharsis.queryParams.RequestParams;

import java.io.Serializable;
import java.lang.annotation.*;

/**
 * <p>
 * Method annotated with this annotation will be used to perform find one operation on a particular resource. The method
 * must be defined in a class annotated with {@link JsonApiResourceRepository}.
 * </p>
 * <p>
 * The requirements for the method parameters are as follows:
 * </p>
 * <ol>
 *     <li>An identifier of a resource</li>
 * </ol>
 * <p>
 * The return value should be a resource of {@link JsonApiResourceRepository#value()} type.
 * </p>
 *
 * @see io.katharsis.repository.ResourceRepository#findOne(Serializable, RequestParams)
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JsonApiFindOne {
}
