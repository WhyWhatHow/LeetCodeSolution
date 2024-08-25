package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_690 {

    public static void main(String[] args) {
        Solution_690 sol = new Solution_690();
        System.out.println("==================");
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    ;

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            int res = 0;
            HashMap<Integer, Employee> map = new HashMap<>();
            for (Employee e : employees) {
                map.put(e.id, e);
            }

            LinkedList<Integer> q = new LinkedList<>();
            q.add(id);
            while (!q.isEmpty()) {
                Integer pop = q.pop();
                Employee e = map.get(pop);
                res += e.importance;
                q.addAll(e.subordinates);
            }

            return res;
        }
    }

}


