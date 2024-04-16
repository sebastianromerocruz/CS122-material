public abstract class A {
    private char b;

    protected A(char one) {
        this.b = one;
        System.out.print('a');
    }

    @Override
    public String toString() {
        return Character.toString(this.b);
    }
}
