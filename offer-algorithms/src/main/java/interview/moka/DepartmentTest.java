package interview.moka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-06-07 12:50
 **/
public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");

        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);


//        List<Department> subDepartments = DepartmentTest.getSub2(3, allDepartment);// bfs+ list实现
        List<Department> subDepartments = DepartmentTest.getSub(6, allDepartment);// 利用bfs + hashmap实现
        int[] arr = new int[]{0, 1, 3, 4, 6, 7, 8};
        for (int i : arr) {
            List list = subList(i, allDepartment);
            System.out.println("'========================test ====================");
            list.forEach(val -> System.out.println(val));
            System.out.println("==========================end =====================");
        }
//        for (Department subDepartment : subDepartments) {
//            System.out.println(subDepartment);
//        }
    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门)
     * bfs 实现
     *
     * @param id
     * @return
     */

    LinkedList list = new LinkedList<>();

    static List subList(int id, List<Department> allDeps) {
        HashMap<Integer, LinkedList> map = new HashMap<>();
        allDeps.forEach(dep -> {
            List orDefault = map.getOrDefault(dep.getPid(), new LinkedList());
            orDefault.add(dep);
            map.put(dep.getPid(), (LinkedList) orDefault);
        });
        LinkedList resList = new LinkedList();
        LinkedList list = map.get(id);
        if (list == null || list.size() == 0) {
            return list;
        }
        while (!list.isEmpty()) {
            Department temp = (Department) list.removeFirst();
            resList.add(temp);
            if (map.containsKey(temp.getId())) {
                list.addAll(map.get(temp.getId()));
            }
        }
        return resList;

    }

    public static List<Department> getSub2(int id, List<Department> allDepartment) {

        LinkedList<Department> list = new LinkedList<>();
        LinkedList<Department> resList = new LinkedList<>();

        List<Department> tempList = new LinkedList<>();

        for (Department department : allDepartment) {
            if (department.getPid() == id) {
                list.add(department);
                resList.add(department);
                tempList.add(department);
            }

        }
        while (!list.isEmpty()) {
            Department department = list.removeFirst();
            for (Department department1 : allDepartment) {
                if (department1.getPid() == department.getId()) {
                    list.add(department1);
                    resList.add(department1);
                }
            }
        }
        return resList;

    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门)
     * hashmap 实现
     *
     * @param id
     * @return
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        LinkedList<Department> list = new LinkedList<>();
        LinkedList<Department> resList = new LinkedList<>();
        HashMap<Integer, LinkedList<Department>> map = new HashMap<>();
        for (Department department : allDepartment) {
            LinkedList orDefault = map.getOrDefault(department.getPid(), new LinkedList());
            orDefault.add(department);
            map.put(department.getPid(), orDefault);
        }
        list = map.get(id);
        if (list == null) {
            return list;
        }
        while (!list.isEmpty()) {
            Department department = list.removeFirst();
            resList.addFirst(department);
            if (map.containsKey(department.getId())) {
                LinkedList<Department> departments = map.get(department.getId());
                list.addAll(departments);
//                resList.addAll(departments);
            }
        }
        return resList;
    }

//    public static List<Department> getSub3(int id, List<Department> allDepartment) {
////        allDepartment.stream().
//    }

    static class Department {
        /**
         * id
         */
        private int id;
        /**
         * parent id
         */
        private int pid;
        /**
         * 名称
         */
        private String name;

        public Department(int id, int pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", pid=" + pid +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

