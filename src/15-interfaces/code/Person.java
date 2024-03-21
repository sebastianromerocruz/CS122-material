package interfaces.visibility;

public abstract class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void celebrateBirthday() {
        System.out.printf("Happy birthday, %s! You are now %d", name, ++age);
    }
}
