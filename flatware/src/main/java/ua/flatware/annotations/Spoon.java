package ua.flatware.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface Spoon {
    int scoopMinVolume() default 5;
    int scoopMaxVolume() default 15;
}
