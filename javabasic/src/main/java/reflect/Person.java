package reflect;

/**
 * @program: javalearning
 * @className: Person
 * @description: TODO
 * @author: xiongbing
 * @create: 2020-11-28 17:00
 **/
public class Person implements MyInterface1, MyInterface2 {
    private int id;
    private String name;
    private int age;


    private void reflectMethod() {
        System.out.println("反射方法：reflectMethod……");
    }

    private void reflectMethod(String name) {
        this.name = name;
        System.out.println("反射方法：reflectMethod2……,name:" + name);
    }

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


