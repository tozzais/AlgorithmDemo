package com.xmm.javabasic;

import com.xmm.javabasic.annotation.Father;
import com.xmm.javabasic.annotation.MyAnno1;
import com.xmm.javabasic.annotation.Son;
import com.xmm.javabasic.annotation.repeatable.AnswerApp;
import com.xmm.javabasic.annotation.repeatable.MyAnnotation;
import com.xmm.javabasic.annotation.repeatable.RepeatableAnnotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

/**

 */
public class AnnotationUnitTest {


    /**
     * 元注解 @Inherited
     */
    @Test
    public void test1() {

        Class<MyAnno1> aClass = MyAnno1.class;
        Documented annotation = aClass.getAnnotation(Documented.class);
        //总结1：当 注解MyAnno1 没有使用元注解Documented的时候。下面语句输出null
        System.out.println(annotation);
        Target annotation1 = aClass.getAnnotation(Target.class);
        System.out.println(annotation1);
        //当使用Father类使用了注解MyAnno1的时候，MyAnno1的元注解通过反射依然没有
        Class<Father> fatherClass = Father.class;
        annotation = fatherClass.getAnnotation(Documented.class);
        System.out.println(annotation);
        MyAnno1 annotation2 = fatherClass.getAnnotation(MyAnno1.class);
        System.out.println(annotation2);
        //当类的注解被元注解@Inherited标识的时候。这个注解会继承到子类
        Class<Son> sonClass = Son.class;
        MyAnno1 annotation3 = sonClass.getAnnotation(MyAnno1.class);
        System.out.println(annotation3);
        System.out.println(annotation3 == annotation2);
    }

    /**
     * 元注解 @Repeatable
     * 必须在JDK1.8中使用
     */
    @Test
    public void test2() {

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
    /**
     * 获取注解
     * 必须在JDK1.8中使用
     */
    @Test
    public void test3() {
        Class<Father> fatherClass = Father.class;
        boolean present = fatherClass.isAnnotationPresent(MyAnno1.class);
        System.out.println(present);
        if (present){
            MyAnno1 annotation = fatherClass.getAnnotation(MyAnno1.class);
            System.out.println(annotation.name());
        }

    }






}