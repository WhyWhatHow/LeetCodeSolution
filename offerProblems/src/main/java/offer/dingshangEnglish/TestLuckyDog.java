package offer.dingshangEnglish;

import java.util.HashMap;
import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-07-02 14:29
 **/
public class TestLuckyDog {
    /**
     * 抽奖
     * 我的思路如下:
     * 1. 先随机生成一个用户的幸运数字, 即userNum
     * 2. 根据中奖率 percent, 随机生成100内的幸运数字 percent个, 将数据保存在hashmap中,避免重复中奖数字.
     * 3. 比对用户幸运数字是否出现在中奖列表中,若有则返回true,没有返回false.
     * @param percent 中奖率
     * @return
     */
    public boolean draw4Prize(int percent) {

        boolean res = false; // 标记用户是否成功抽到奖
        Random random = new Random();
        int userNum = random.nextInt(100); // 用户的幸运数字
        System.out.println(userNum);
        HashMap<Integer,Boolean> map =new HashMap();

        while (percent > 0) {
            int   luck= random.nextInt(100);
            if (map.containsKey(luck)) {
                System.out.println("repeat ....");
                continue;
            }else {
                map.put(luck,true);
                percent--;
            }
            System.out.println("--- luck"+ luck);
            if (userNum == luck) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TestLuckyDog dog =new TestLuckyDog();
        HashMap map= new HashMap(7);
        map.size();
        map.put(1,1);

        boolean b = dog.draw4Prize(90);
        System.out.println(b);
    }
}
