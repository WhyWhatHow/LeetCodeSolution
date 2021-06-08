package lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
class AnimalShelf {
    LinkedList<Integer> stackCat = new LinkedList<>();
    LinkedList<Integer> stackDog = new LinkedList<>();

    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            stackCat.addLast(animal[0]);
        } else {
            stackDog.addLast(animal[0]);
        }
    }


    public int[] dequeueAny() {
        if (stackDog.isEmpty() && stackCat.isEmpty()) {
            return new int[]{-1, -1};
        } else if (stackCat.isEmpty()) {
            return dequeueDog();
        } else if (stackDog.isEmpty()) {
            return dequeueCat();
        } else {
            Integer dog = stackDog.getFirst();
            Integer cat = stackCat.getFirst();
            return dog < cat ?dequeueDog():dequeueCat();
        }

    }

    public int[] dequeueDog() {
        if (stackDog.isEmpty()) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[1] = 1;
        Integer pop = stackDog.removeFirst();
        res[0] = pop;
        return res;
    }

    public int[] dequeueCat() {
        if (stackCat.isEmpty()) {
            return new int[]{-1, -1};
        }
        Integer pop = stackCat.removeFirst();
        return new int[]{pop, 0};
    }
}


/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
public class Solution_0306 {

    public static void main(String[] args) {
        Solution_0306 sol = new Solution_0306();
        System.out.println("==================");
    }
}


