package utilities.selenium;

import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface uiMap {
    public String val();
}