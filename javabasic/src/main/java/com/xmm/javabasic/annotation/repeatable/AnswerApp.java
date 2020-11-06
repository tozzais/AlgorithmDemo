package com.xmm.javabasic.annotation.repeatable;

import java.lang.annotation.Annotation;

@MyAnnotation(value = "Jaemon", name = "J.M")
@MyAnnotation(value = "Jaemon1", name = "J.M1")
public class AnswerApp {
    public static void main(String[] args) {
        for (Annotation annotation : AnswerApp.class.getAnnotations()) {
            System.out.println(annotation.toString());
        }
        System.out.println();

        RepeatableAnnotation annotation = AnswerApp.class.getAnnotation(RepeatableAnnotation.class);
        for (MyAnnotation myAnnotation : annotation.value()) {
            System.out.println(myAnnotation.value());
            System.out.println(myAnnotation.name());
        }
    }
}
