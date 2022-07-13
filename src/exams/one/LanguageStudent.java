package exams.one;

public class LanguageStudent extends Person {


    public static void main (String[] args) {
        Person you = new LanguageStudent();
        you.sayHello();
    }

    @Override
    public void sayHello() {
        System.out.println("こんにちは！");
    }
}


