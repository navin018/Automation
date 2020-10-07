package utilities.selenium;

import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface UIAnnot {
	public String fieldMode() default "";
	public String[] View() default {"visible=true","enabled=false"};
	public String[] Edit() default {"visible=true","enabled=true"};
	public String[] DynamicInView() default {"visible=true","enabled=true"};
	public String[] DynamicInEdit() default {"visible=true","enabled=false"};
	public String claimType() default "Single";

}