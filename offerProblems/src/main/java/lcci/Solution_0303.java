package lcci;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
class StackOfPlates {

    LinkedList<Stack<Integer>> list = new LinkedList<Stack<Integer>>();
    int cap; // 表示每个栈的大小

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (this.cap <= 0) {
            return;
        }
        if (list.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            temp.push(val);
            list.addLast(temp);
            return;
        }
        Stack<Integer> last = list.getLast();
        if (last.size() < cap) {
            last.push(val);
        } else {
            Stack<Integer> temp = new Stack<>();
            temp.push(val);
            list.addLast(temp);
        }
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        Stack<Integer> last = list.getLast();
        Integer pop = last.pop();
        if (last.isEmpty()) {
            list.removeLast();
        }
        return pop;
    }

    public int popAt(int index) {
        if (list.size() <= index) {
            return -1;
        }
        Stack<Integer> stack = list.get(index);
        if (stack == null) {
            return -1;
        }
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            list.remove(index);
        }
        return pop;
    }
}

public class Solution_0303 {
//    ["StackOfPlates", "pop", "pop", "popAt", "popAt", "pop", "push", "push", "push", "push", "pop", "push", "push", "popAt", "pop", "popAt", "push", "popAt", "pop", "push", "pop", "pop", "pop", "popAt", "push", "pop", "popAt", "pop", "push", "popAt", "popAt", "push", "popAt", "popAt",
//    "push", "pop", "popAt", "popAt", "popAt", "pop", "popAt", "popAt", "push", "popAt", "push", "push", "pop", "popAt", "popAt", "push", "popAt", "push", "pop", "pop", "push", "push", "push", "popAt", "popAt", "pop", "popAt", "pop", "pop", "push", "push"]
//            [[6], [], [], [1], [3], [], [40], [10], [44], [44], [], [24], [42], [4], [], [0], [42], [5], [], [29], [], [], [], [0], [56], [], [4], [], [34], [1], [4], [52], [4], [6], [63], [], [6], [6], [1], [], [6], [2], [47], [1], [45], [52], [], [6], [6], [20], [4], [17], [], [], [43], [6], [30], [2], [3], [], [3], [], [], [51], [46]]

//    ["StackOfPlates",
//    "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push",
//    "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop"]
//            [
//      [0],
//      [2], [8], [56], [1], [39], [40], [44], [63], [11], [38], [20], [55], [25], [14], [11], [1], [20], [16], [6], [18], [3], [39], [45], [2], [22], [64], [6], [30], [39], [3], [19], [63], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]

// ["StackOfPlates", 3
// "pop",-1 "popAt", "push", 1"popAt",-1 "popAt",-1
// "pop",1 "pop",-1 "push",9 "popAt",-1 "pop",9
// "push",51 "push",20 "pop",20 "popAt",-1 "popAt",51

// "push", 35"push",1 "push",19 "popAt",-1 "pop",19
// "pop",1 "pop",35 "popAt",-1 "pop",-1 "push", 36

// "popAt",-1 "push",19 "push",3 "popAt",-1 "push",15
// "push",44 "pop",44 "popAt",-1 "push",46 "pop",46

// "popAt", "push", "pop", "push", "pop",
// "popAt", "popAt", "pop", "push", "push",
// "pop", "popAt", "push", "push", "pop",
// "pop", "popAt"]
//         [[3],
//         [], [1], [1], [2], [2],
//         [], [], [9], [3], [],
//         [51], [20], [], [2], [0],
//         [35], [1], [19], [3], [],
//         [], [], [1], [], [36], [1],
//         [19], [3], [3], [15],  [44],
//         [], [3], [46], [], [0],  [42],
//         [], [31], [], [0], [2],
//         [], [10], [49], [], [1],
//         [14], [50], [], [], [3]]

    public static void main(String[] args) {
        Solution_0303 sol = new Solution_0303();
        StackOfPlates stackOfPlates = new StackOfPlates(3);
//        "push", 36


// "popAt",-1 "push",19 "push",3 "popAt",-1 "push",15
// "push",44 "pop",44 "popAt",-1 "push",46 "pop",46
        stackOfPlates.push(36);
        stackOfPlates.popAt(1);
        stackOfPlates.push(19);
        stackOfPlates.push(3);
        stackOfPlates.popAt(3);
        stackOfPlates.push(15);
        stackOfPlates.push(44);
        int pop1 = stackOfPlates.pop();
        stackOfPlates.popAt(3);
        stackOfPlates.push(46);
        int pop = stackOfPlates.pop();
//        stackOfPlates.push(1);
//        stackOfPlates.push(2);
//        stackOfPlates.popAt(1); // 2
//        stackOfPlates.pop(); // 1/
//        stackOfPlates.pop(); //-1
        System.out.println("==================");
    }
}


