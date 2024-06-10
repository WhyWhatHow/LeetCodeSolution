package interview.dingshangEnglish;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-07-03 13:07
 **/
public class TestStackOverflow {
    public static void main(String[] args) {
        A a = new A();

        B b = new B();
        a.b = b;
        b.a = a;
        b.toString();
        a.toString();
    }
}

class A {
    B b;

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}

class B {
    A a;

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}
