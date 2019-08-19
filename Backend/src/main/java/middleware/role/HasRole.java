package middleware.role;

import domain.user.AccessLevel;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasRole {
	AccessLevel role() default AccessLevel.CLIENT;
}
