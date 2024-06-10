package design_patten;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式:
 * 观察者:  3观察者做出反馈,回馈观察物体
 * 观察对象: 1.bind 观察者,
 *          2对象发生变化,通知观察者
 * @program: LeetCodeSolution
 * @description: 观察者模式demo
 * @author: WhyWhatHow
 * @create: 2020-10-27 09:21
 **/

/**
 * 观察的物体
 */
class MyObj {
    List<Observer> list = new ArrayList<>();
    void addObserver(Observer observer){list.add(observer);}
    void remove() {
        list.forEach(obj -> {
            obj.observeSth(this);
        });
    }
    void  receive(){
        System.out.println(" myobj receirve");
    }
}

interface Observer {
    void observeSth(MyObj obj);
}

class ObserverA implements Observer {
    @Override
    public void observeSth(MyObj obj) {
        System.out.println(" Observer A see");
        obj.receive();
    }
}


class ObserverB implements Observer {

    @Override
    public void observeSth(MyObj obj) {
        System.out.println(" B do sth");
        obj.receive();
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        MyObj obj =new MyObj();
        ObserverA a =new ObserverA();
        ObserverB b =new ObserverB();
        obj.addObserver(a);
        obj.addObserver(b);
        obj.remove();
    }
}
