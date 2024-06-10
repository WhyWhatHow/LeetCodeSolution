package design_patten;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-10-27 09:14
 **/
abstract class Father{
    abstract  void aVoid();
    abstract  void bVoid();
    void doSth(){
        aVoid();
        bVoid();
    }
}
class Son extends  Father{

    @Override
    void aVoid() {
        System.out.println("Son avoid ");
    }

    @Override
    void bVoid() {
        System.out.println("son b void ");
    }
}
class Daughter extends  Father{

    @Override
    void aVoid() {
        System.out.println( "da a");
    }

    @Override
    void bVoid() {
        System.out.println("da b");
    }
}
public class TemplateMethodDemo {
    public static void main(String[] args) {

        Son son =new Son();
        son.doSth();
        Daughter daughter =new Daughter();
        daughter.doSth();
    }
}
