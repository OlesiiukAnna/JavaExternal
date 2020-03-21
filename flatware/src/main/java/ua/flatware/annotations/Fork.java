package ua.flatware.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface Fork {
    int prongMinLength() default 1;
    int prongMaxLength() default 7;
    int prongMinQuantity() default 2;
    int prongMaxQuantity() default 5;
}
