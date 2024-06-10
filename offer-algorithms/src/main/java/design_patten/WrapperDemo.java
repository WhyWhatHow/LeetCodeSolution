package design_patten;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-10-27 09:17
 **/
class Base{
    void show(){
        System.out.println("this is base ");
    }
}

/**
 *  委托的方式, 或者说是代理模式
 */
class BaseWrapper {
    Base base;
    void show(){
        System.out.println( " before ");
        base.show();
        System.out.println("after");
    }
}

/**
 *  继承的方式
 */
class BaseWrapperEx extends Base{
    @Override
    void  show(){

    }
}
public class WrapperDemo {
}
