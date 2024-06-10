package design_patten;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-10-27 09:06
 **/
abstract class Support {
    Support next;

    Support setNext(Support next) {
        this.next = next;
        return next;
    }

    ;

    abstract void plugin();
}

class NoSupport extends Support {

    @Override
    void plugin() {
        System.out.println("no Support");
        next.plugin();
    }
}

class DoSupport extends Support {
    @Override
    void plugin() {
        System.out.println("do support ");
    }
}

public class SetNextChainDemo {
    public static void main(String[] args) {

        NoSupport no = new NoSupport();
        DoSupport doSupport = new DoSupport();
        no.setNext(doSupport);
        no.plugin();
    }
}
