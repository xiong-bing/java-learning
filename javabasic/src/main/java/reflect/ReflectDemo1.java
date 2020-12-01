package reflect;

import cn.hutool.core.util.ArrayUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: javalearning
 * @className: ReflectDemo1
 * @description: TODO
 * @author: xiongbing
 * @create: 2020-11-28 17:13
 **/
public class ReflectDemo1 {

    public static void main(String[] args) {
        //获取反射对象(反射入口):
        getClass1();

    }

    /**
     * 全类名获取Class
     */
    public static void getClass1() {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("reflect.Person");
            System.out.println(perClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //getPublicMethod(perClazz);
        //getAllInteface(perClazz);
        //getSuperclass(perClazz);
        //getConstructors(perClazz);
        //getCurrentAttr(perClazz);
        //getReflectObject(perClazz);
        getReflectOpe(perClazz);
    }


    /**
     * 通过反射机制操作类的属性和方法
     *
     * @param clazz
     */
    public static void getReflectOpe(Class clazz) {
        Person person = null;
        try {
            person = (Person) clazz.newInstance();
            Field idField = clazz.getDeclaredField("id");
            //修改属性的访问权限
            idField.setAccessible(true);
            idField.set(person, 1);
            System.out.println(person.getId());
            //方法的调用是通过invoke来进行
            //Method method = clazz.getDeclaredMethod("reflectMethod", null);
            //method.setAccessible(true);
            //method.invoke(person, null);
            //有参方法
            Method method2 = clazz.getDeclaredMethod("reflectMethod", String.class);
            method2.setAccessible(true);
            method2.invoke(person, "张三");
            System.out.println("person name :" + person.getName());
        } catch (NoSuchFieldException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过反射获取对象
     *
     * @param clazz
     */
    public static void getReflectObject(Class clazz) {
        Person person = null;
        try {
            person = (Person) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        person.setName("熊兵");
        person.setAge(32);
        System.out.println(person.getName() + "," + person.getAge());
    }

    /**
     * 获取当前类所有方法
     * Declared 表示当前类所有，不含表示父类，接口，本类中公共的
     *
     * @param clazz
     */
    public static void getCurrentAttr(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    /**
     * 获取父类
     *
     * @param clazz
     */
    public static void getSuperclass(Class clazz) {
        Class<?> supper = clazz.getSuperclass();
        System.out.println(supper);
    }

    /**
     * 所有构造方法
     *
     * @param clazz
     */
    public static void getConstructors(Class clazz) {
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
    }

    /**
     * 获取类中所有的接口
     *
     * @param clazz
     */
    public static void getAllInteface(Class clazz) {
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println(inter);
        }
    }

    /**
     * 获取所有的公共方法(本类，父类，接口中并且符合方法修饰符条件的方法)
     */
    public static void getPublicMethod(Class clazz) {
        //获取所有的公共方法
        Method[] methods = clazz.getMethods();
        if (ArrayUtil.isNotEmpty(methods)) {
            for (Method method : methods) {
                System.out.println(method);
            }
        }
    }

    /**
     * xx.class
     */
    public static void demo2() {

    }

    /**
     * 对象.class
     */
    public static void demo3() {
        try {
            Class<?> perClazz = Class.forName("Person");
            System.out.println(perClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}


