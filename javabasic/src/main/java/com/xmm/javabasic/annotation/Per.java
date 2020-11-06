package com.xmm.javabasic.annotation;


import java.lang.annotation.Repeatable;

@Repeatable(Persons.class)
public @interface Per {
    String role() default "";
}
