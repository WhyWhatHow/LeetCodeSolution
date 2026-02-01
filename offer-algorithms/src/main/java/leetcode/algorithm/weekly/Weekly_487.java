package leetcode.algorithm.weekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2025-12-07 10:29
 **/
public class Weekly_487 {
    public static void main(String[] args) {
        Weekly_487 sol = new Weekly_487();
        System.out.println(sol.finalElement(new int[]{
                1, 5, 2, 6, 3, 8, 9, 1, 9
//                1,5,2
        }));
//        RideSharingSystem rideSharingSystem = new RideSharingSystem(); // 初始化系统
//        rideSharingSystem.addRider(8); // 乘客 8 加入队列
//        rideSharingSystem.addDriver(8); // 司机 8 加入队列
//        rideSharingSystem.addDriver(6); // 司机 6 加入队列
//        rideSharingSystem.matchDriverWithRider(); // 返回 [8, 8]
//        rideSharingSystem.addRider(2); // 乘客 2 加入队列
//        rideSharingSystem.cancelRider(2); // 乘客 2 取消
//        rideSharingSystem.matchDriverWithRider(); // 返回 [-1, -1]
//        RideSharingSystem rideSharingSystem = new RideSharingSystem(); // 初始化系统
//        rideSharingSystem.addRider(3); // 乘客 3 加入队列
//        rideSharingSystem.addDriver(2); // 司机 2 加入队列
//        rideSharingSystem.addRider(1); // 乘客 1 加入队列
//        rideSharingSystem.matchDriverWithRider(); // 返回 [2, 3]
//        rideSharingSystem.addDriver(5); // 司机 5 变为可用
//        rideSharingSystem.cancelRider(3); // 乘客 3 已被匹配，取消操作无效
//        rideSharingSystem.matchDriverWithRider(); // 返回 [5, 1]
//        rideSharingSystem.matchDriverWithRider(); // 返回 [-1, -1]
        System.out.println("---------------------");
    }

    public int finalElement(int[] nums) {
        //1,5,2,6,3,8, 9,1,9
        if (nums.length == 1) return nums[0];
        else return Math.max(nums[0], nums[nums.length - 1]);
    }

    public int countMonobit(int n) {
        // 0,1,3,7,
        if (n == 0) return 1;
        if (n == 1) return 2;
        int a = 2;
        int cnt = 2;
        int v = a - 1;
        while (v < n) {
            a *= 2;
            v = a - 1;
            if (v > n) break;
            cnt++;
        }
        return cnt;
    }
}

class RideSharingSystem {
    // rider && driver  inorder
    int cnt = 0;
    // int[]=>{ id, timesmap}
    TreeSet<int[]> riders = new TreeSet<>((a, b) -> {
        return a[1] - b[1];
    });
    TreeSet<int[]> drivers = new TreeSet<>((a, b) -> {
        return a[1] - b[1];
    });
    //    每个 riderId 在乘客中是唯一的，且最多被添加一次。
//    每个 driverId 在司机中是唯一的，且最多被添加一次。
    // riderId, val: cnt
    HashMap<Integer, Integer> rs = new HashMap<>(); // 在system中的riders
    HashSet<Integer> ds = new HashSet<>();

    HashSet<Integer> urs = new HashSet<Integer>();// 使用过的riders
    HashSet<Integer> uds = new HashSet<Integer>();// 使用过的riders

    public RideSharingSystem() {
    }

    public void addRider(int riderId) {
        if (urs.contains(riderId)) return;
        cnt++;
        rs.put(riderId, cnt);
        riders.add(new int[]{riderId, cnt});
    }

    public void addDriver(int driverId) {
        if (uds.contains(driverId)) return;
        ds.add(driverId);
        drivers.add(new int[]{driverId, cnt++});
    }

    //    int[] matchDriverWithRider() 匹配最早到达的空闲司机和最早等待的乘客，
//    并将这两者从系统中移除。
//    返回一个大小为 2 的整数数组，result = [driverId, riderId]，表示匹配成功。
//    如果没有可用的匹配，返回 [-1, -1]。
    public int[] matchDriverWithRider() {
        if (riders.isEmpty() || drivers.isEmpty())
            return new int[]{-1, -1};
        int riverid = riders.pollFirst()[0];
        int driverid = drivers.pollFirst()[0];
        urs.add(riverid);
        uds.add(driverid);
        rs.remove(riders);
        cnt++;
        return new int[]{driverid, riverid};
    }

    //   取消指定 riderId 的乘客的叫车请求，前提是该乘客存在并且尚未被匹配。
    public void cancelRider(int riderId) {
        // 表示有当前乘客.
        if (!urs.contains(riderId) && rs.containsKey(riderId)) {
            Integer val = rs.get(riderId);
            int[] t = new int[]{riderId, val};
            if (riders.contains(t)) {
                riders.remove(t);
            }
            rs.remove(riderId);
            urs.add(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */