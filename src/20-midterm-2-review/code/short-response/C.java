public class C extends A implements B {
    public static final char H = 'i';

    public static void main(String[] args) {
        System.out.print('o');
        C c = new C('p');
        System.out.print(c);

        /*
         * SOLUTION: oajifi
         */
    }

    public C(char two) {
        super(H);
        System.out.print('j');
        System.out.print(super.toString());
        System.out.print(e);
    }
}
