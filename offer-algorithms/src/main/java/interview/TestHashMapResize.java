package interview;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-10-27 10:23
 **/
public class TestHashMapResize {

    public static void main(String[] args) {

        HashMap map =new HashMap<Object,Object>();
        ConcurrentHashMap map1 = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(1, i);
        }
    }
}
