package interfaces.visibility;

public class Programmer extends Person {
    private final String favouriteProgrammingLanguage;

    public static void main(String[] args) {
        Programmer sebastian = new Programmer("Sebastián", 29, "Java");

        // By virtue of invoking this method, we have indirectly modified a private attribute of the Person class
        sebastian.celebrateBirthday();
    }

    public Programmer(String name, int age, String favouriteProgrammingLanguage) {
        super(name, age);
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }
}
