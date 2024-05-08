package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2105 {

    public static void main(String[] args) {
        Solution_2105 sol = new Solution_2105();
        System.out.println(sol.minimumRefill(new int[]{
//                        5
//                        2, 2, 3, 3
//                        1, 2, 4, 4, 5
                        7, 7, 7, 7, 7, 7, 7
                },
//                6,5
                8, 7
//                4
//                8
        ));

        System.out.println("==================");
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int nowa = capacityA;
        int nowb = capacityB;
        int res = 0;
        int l = 0, r = plants.length - 1;

        while (l < r) {
            // a fill
            if (nowa < plants[l]) {
                nowa = capacityA;
                res++;
            }
            nowa -= plants[l++];
            // b fill
            if (nowb < plants[r]) {
                nowb = capacityB;
                res++;
            }
            nowb -= plants[r--];
        }
        if(l==r && Math.max(nowa,nowb)< plants[l]){
            res++ ;
        }
        return res ;
    }

    public int minimumRefillStupid(int[] plants, int capacityA, int capacityB) {
        int nowa = capacityA; //
        int nowb = capacityB;
        int ca = 0; // a steps
        int cb = 0; // b steps
        int l = 0, r = plants.length - 1;

        while (l < r) {
            // a fill time
            if (nowa >= plants[l]) {
                nowa -= plants[l];
            } else {
                nowa = capacityA - plants[l];
                ca++;
            }
            plants[l++] = 0;

            // b fill time
            if (nowb >= plants[r]) {
                nowb -= plants[r];
            } else {
                nowb = capacityB - plants[r];
                cb++;
            }
            plants[r--] = 0;
        }
        if (l == r) {
            if (nowa >= nowb) {
                if (nowa >= plants[l]) {
                    nowa -= plants[l];
                } else {
                    nowa = capacityA - plants[l];
                    ca++;
                }
            } else {
                if (nowb >= plants[r]) {
                    nowb -= plants[r];
                } else {
                    nowb = capacityB - plants[r];
                    cb++;
                }
            }

        }
        return ca + cb;

    }

}


