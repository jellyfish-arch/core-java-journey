package Day07;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value() default "Default Info";
    int version() default 1;
}

class AnnotatedClass {
    @MyAnnotation(value = "Custom Method Annotation", version = 2)
    public void myAnnotatedMethod() {
        System.out.println("Inside myAnnotatedMethod");
    }
}

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        AnnotatedClass obj = new AnnotatedClass();
        Method m = obj.getClass().getMethod("myAnnotatedMethod");

        if (m.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation Value: " + annotation.value());
            System.out.println("Annotation Version: " + annotation.version());
        }
        
        obj.myAnnotatedMethod();
    }
}
