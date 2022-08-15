package exams.two;

public class Exam {
    public static int countCharacters(String string, char character) {
        // 10 points
        if (string == null) throw new NullPointerException();

        // 10 points
        if (string.length() == 1) {
            return string.charAt(0) == character ? 1 : 0;
        }

        char head = string.charAt(0);
        String tail = string.substring(1);

        if (head == character) {
            // 10 points
            return 1 + countCharacters(tail, character);
        } else {
            // 10 points
            return countCharacters(tail, character);
        }
    }

    public static void main(String[] args) {
        String string = "MOS MCS 6502 1975";
        System.out.println(countCharacters(string, '5'));
    }
}
