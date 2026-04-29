package Day07;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

class SampleClass {
    private String name;

    public SampleClass() {
        this.name = "Reflection Demo";
    }

    public void display() {
        System.out.println("Name: " + name);
    }

    private void privateMethod() {
        System.out.println("This is a private method!");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        SampleClass obj = new SampleClass();
        Class<?> cls = obj.getClass();
        
        System.out.println("Class Name: " + cls.getName());
        
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("\nMethods:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Access private method
        System.out.println("\nInvoking private method:");
        Method privateMethod = cls.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);

        // Access private field
        System.out.println("\nAccessing private field:");
        Field privateField = cls.getDeclaredField("name");
        privateField.setAccessible(true);
        privateField.set(obj, "Modified via Reflection");
        obj.display();
    }
}
