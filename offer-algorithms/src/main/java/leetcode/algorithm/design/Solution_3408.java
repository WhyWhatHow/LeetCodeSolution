package leetcode.algorithm.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3408 {

    public static void main(String[] args) {
        Solution_3408 sol = new Solution_3408();
        TaskManager tm = new TaskManager(List.of(
                List.of(1,101,8),
                List.of(2,102,20),
                List.of(3,103,5)
        ));
        tm.add(4,104,5);
        tm.edit(102,9);
        System.out.println(tm.execTop());

        System.out.println("==================");
    }


}


class TaskManager {

    HashMap<Integer, Integer> map = new HashMap<>(); // key taskId, val: uid
    int[] ts = new int[1000_01];
    ; // 查表 pq 优先级, -1 表示不存在
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[1] != b[1]) return b[1] - a[1];
        else return b[0] - a[0];
    }); // {taskId, priority}

    public TaskManager(List<List<Integer>> tasks) {
        // init taskManager
        Arrays.fill(ts, -1);
        tasks.forEach(l -> {
//            [userId, taskId, priority]
            int uid = l.get(0);
            int tid = l.get(1);
            int p = l.getLast();
            map.put(tid, uid);
            ts[tid] = p;
            pq.add(new int[]{tid, p});
        });
    }

    public void add(int userId, int taskId, int priority) {
        ts[taskId] = priority;
        map.put(taskId, userId);
        pq.add(new int[]{taskId, priority});
    }

    public void edit(int taskId, int newPriority) {
        ts[taskId] = newPriority;
        pq.add(new int[]{taskId,newPriority});
    }

    public void rmv(int taskId) {
        ts[taskId] = -1;
    }

    public int execTop() {
        // find taskId
        int taskid = -1;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (ts[p[0]] != p[1] || ts[p[0]] == -1) continue; // remove useless data.
            else {
                taskid = p[0];
                break;
            }
        }
        if (taskid == -1) return -1; // not found
        // run task
        rmv(taskid);
        // return  uid
        return map.get(taskid);
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */