package LRU;

import java.util.LinkedHashMap;

/**
 * @program: LeetCodeSolution
 * @description: lru算法 通过linkedhashmap 实现查找o(1),增删o(1)的复杂度
 * @author: WhyWhatHow
 * @create: 2021-01-08 13:37
 **/
public class LRULinkedHashMap <T>{
    LinkedHashMap<Integer,T> map= new LinkedHashMap<Integer, T>(16,0.75f,true);

    /**
     *  lru 算法描述:
     *   1.在固定的容量下 即链表长度 假设
     *
     *
     */
    public static void main(String[] args) {

    }

}
