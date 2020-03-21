package ua.flatware.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface Knife {
    int scoopMinLength() default 4;
    int scoopMaxLength() default 20;
    int bladeMinWidth() default 1;
    int bladeMaxWidth() default 10;
}
