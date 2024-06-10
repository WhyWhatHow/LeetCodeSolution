package leetcode.algorithm.demo;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_1226 {

    public static void main(String[] args) {
        Solution_1226 sol = new Solution_1226();
        System.out.println("==================");
    }
}

class DiningPhilosophers {

    /**
     * 思路:  一个 哲学家, 同时拿到 左右两双筷子即可.
     * 1st commit :
     * pickLeftFork.run();
     * pickRightFork.run();
     * eat.run();
     * putLeftFork.run();
     * putRightFork.run();
     * result: wrong , 原因 是 未设置锁,导致  进餐失败
     */
    public DiningPhilosophers() {

    }
//3952b8ff-d82d-475b-b793-d73303e55d1e
    final ReentrantLock[] list = new ReentrantLock[]{
        new  ReentrantLock(),new  ReentrantLock(),new  ReentrantLock(),new  ReentrantLock(),new  ReentrantLock()
    };// 筷子编号
    final ReentrantLock both = new ReentrantLock();// 同时持有 两双筷子

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;
        list[left].lock();
        list[right].lock();
        both.lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        both.unlock();
        putLeftFork.run();
        putRightFork.run();
        list[left].unlock();
        list[right].unlock();
    }
}

