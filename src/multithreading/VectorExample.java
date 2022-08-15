package multithreading;

import java.util.ArrayList;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> students = new Vector<String>(2, 5);

        System.out.printf("The `students` vector, before adding students, has a capacity of: %d\n%n",
                students.capacity());

        students.add("Justin");
        students.add("Sarp");
        students.add("Sean");
        students.add("Cristian");
        students.add("Parker");

        System.out.printf("The `students` vector, after adding students has a capacity of: %d\n%n",
                students.capacity());

        for (int i = 0; i < students.size(); i++) System.out.println(students.get(i));
        for (int i = 0; i < students.capacity(); i++) System.out.println(students.get(i));

        ArrayList<String> programmers = new ArrayList<String>(3);

        System.out.printf("The `students` list, before adding students, has a size of: %d\n%n",
                programmers.size());

        programmers.add("Justin");
        programmers.add("Sarp");
        programmers.add("Sean");
        programmers.add("Cristian");
        programmers.add("Parker");

        System.out.printf("The `students` list, before adding students, has a size of: %d\n%n",
                programmers.size());
    }
}
