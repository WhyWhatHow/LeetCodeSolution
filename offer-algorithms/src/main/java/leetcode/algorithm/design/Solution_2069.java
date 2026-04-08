package leetcode.algorithm.design;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2069 {

    public static void main(String[] args) {
        Solution_2069 sol = new Solution_2069();//
        Robot robot = new Robot(
//                6, 3
                8, 2
        ); // 初始化网格图，机器人在 (0, 0) ，朝东。
//        robot.step(2);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
//        robot.step(3);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
//        robot.getPos(); // 返回 [5, 0]
//        robot.getDir(); // 返回 "East"
//        robot.step(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
//        // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
//        // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
//        robot.step(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
//        robot.step(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
        // 然后，移动 4 步到 (1, 2) ，并朝西。
        robot.step(176);
        robot.getPos(); // 返回 [1, 2]
        robot.getDir(); // 返回 "West"

        System.out.println("==================");
    }


}

class Robot {
    int w, h, cur;
    int all;
    //需要考虑第一次没有动的情况, (0,0) 可以指向东(no step),也可以指向南(step after)
    boolean first = true;

    public Robot(int width, int height) {
        w = width;
        h = height;
        all = 2 * (w + h) - 4;
    }

    public void step(int num) {
        first = false;
        cur = (cur + num);
    }

    public int[] getPos() {
        var now = getState();
        return new int[]{(int) now[0], (int) now[1]};
    }

    private Object[] getState() {
        int t = cur % all;
        if (t == 0) {
            var s = first ? "East" : "South";
            return new Object[]{0, 0, s};
        } else if (t <= w - 1) {
            return new Object[]{t, 0, "East"};
        } else if (t <= w + h - 2) {
            return new Object[]{w - 1, t - w + 1, "North"};
        } else if (t <= w + w + h - 3) {
            return new Object[]{w - 1 - (t - w - h + 2), h - 1, "West"};
        } else {
            return new Object[]{0, all - t, "South"};
        }
    }

    public String getDir() {
        return (String) getState()[2];
    }

}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */