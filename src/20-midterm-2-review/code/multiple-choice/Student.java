public class Student extends Person {
    private String major;

    public static void main(String[] args) {
        Person[] people = {
            new Student("Sebastián", "Chemical and Biomolecular Engineering"),
            new Student("Jemma", "Biomolecular Science")
        };
    }

    protected Student(String major, String name) {
        this.major = name;
        super(major);
    }
}