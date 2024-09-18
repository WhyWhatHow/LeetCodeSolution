package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2332 {

    public static void main(String[] args) {
        Solution_2332 sol = new Solution_2332();
        System.out.println(sol.latestTimeCatchTheBus(new int[]{
//                        20, 30, 10
//                        3, 2
//                        3
                        4230,9309,1239,5342,2455,5730,1043,8049,7996,7647,1159,7998,4473,8026,6096,1218,94,6960,1685,4744,6038,9223,388,1886,8156,4389,7948,9633,2130,5367,5145,8371,5146,2858,9437,1192,9542,9996,4596,7522,1975,5029,4213,8260,5061,9245,5042,5131,43,7083,9367,4640,7324,7128,290,8942,766,782,45,8016,9513,6650,7277,3869,9387,1887,6231,2510,6838,9685,6073,2044,9547,9296,9255,2333,8242,4637,4936,3724,6701,4139,5682,2413,8708,1264,9183,6235,687,3856,3793,1645,9981,3104,7779,998,1084,6411,51,1593
                }, new int[]{
//                        19, 13, 26, 4, 25, 11, 21
//                        2
                        9959,9968,9972,9949,9948,9960,9993,9900,9921,9975,9963,9938,9916,9950,9953,9911,9923,9940,9913,9925,9901,9951,9899,9910,9918,9976,9980,9962,9933,9956,9926,9982,9969,9955,9978,9909,9952,9896,9915,9964,9903,9905,9919,9971,9937,9931,9981,9994,9904,9929,9991,9945,9946,9897,9977,9967,9970,9898,9936,9912,9983,9990,9907,9986,9965,9902,9979,9985,9992,9961,9928,9934,9917,9943,9941,9947,9906,9966,9954,9939,9922,9944,9924,9973,9908,9914,9957,9942,9920,9932,9989,9930,9958,9927,9984,9935,9988,9974,9995,9987
                },
//                2
//                1
                4
        ));
        System.out.println("==================");
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        Stack<Integer> bs = new Stack<>();
        Stack<Integer> ps = new Stack<>();
        int i = 0;
        bs.push(buses[i]);
        int cap = 0;
        for (int j = 0; j < passengers.length; j++) {
            while (cap == capacity || bs.peek() < passengers[j]) {
                i++;
                if (i == buses.length) break;
                bs.push(buses[i]);
                cap = 0;
            }
            if (i == buses.length) break;
            ps.push(passengers[j]);
            cap++;
        }
        // last buses
        while (++i < buses.length) {
            bs.push(buses[i]);
            cap = 0;
        }

        int peek = !ps.isEmpty() ? ps.peek() : bs.peek();
        if (cap < capacity && peek < bs.peek()) {
            // go right
            int pos = Arrays.binarySearch(passengers, peek);
            peek++;
            for (int k = pos + 1; k < passengers.length; k++) {
                if (peek != passengers[k]) break;
                peek++;
            }
            if (peek < bs.peek()) peek = bs.peek();
        } else {
            while (peek > 0 && !ps.isEmpty()) {
                if (peek > ps.peek()) break;
                if (peek == ps.peek()) {
                    ps.pop();
                }
                peek--;

            }
        }
        return peek;

    }


}


