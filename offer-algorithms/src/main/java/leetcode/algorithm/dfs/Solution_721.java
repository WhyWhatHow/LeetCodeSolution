package leetcode.algorithm.dfs;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_721 {

    public static void main(String[] args) {
        Solution_721 sol = new Solution_721();
        List<List<String>> accounts = new ArrayList<>();

        List<String> account1 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        List<String> account2 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        List<String> account3 = new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"));
        List<String> account4 = new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"));

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

//        List<List<String>> accounts = new ArrayList<>();
//
//        List<String> account1 = new ArrayList<>(Arrays.asList("David", "David0@m.co", "David4@m.co", "David3@m.co"));
//        List<String> account2 = new ArrayList<>(Arrays.asList("David", "David5@m.co", "David5@m.co", "David0@m.co"));
//        List<String> account3 = new ArrayList<>(Arrays.asList("David", "David1@m.co", "David4@m.co", "David0@m.co"));
//        List<String> account4 = new ArrayList<>(Arrays.asList("David", "David0@m.co", "David1@m.co", "David3@m.co"));
//        List<String> account5 = new ArrayList<>(Arrays.asList("David", "David4@m.co", "David1@m.co", "David3@m.co"));
//
//        accounts.add(account1);
//        accounts.add(account2);
//        accounts.add(account3);
//        accounts.add(account4);
//        accounts.add(account5);
        System.out.println(sol.accountsMerge(accounts));
//        LinkedList<String> account = new LinkedList<>();
//        account.add("John");
//        account.add("johnsmith@mail.com");
//        account.add("john_newyork@mail.com");
        System.out.println("==================");
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List resList = new LinkedList();
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, TreeSet<String>> graph = new HashMap<>(); // email -> email

        // init graph
        for (List<String> account : accounts) {
            String name = null, email;
            for (int i = 0; i < account.size(); i++) {

                String val = account.get(i);
                if (i == 0) {
                    name = val;
                    continue;
                } else {
                    email = val;
                }
                emailToName.put(email, name);
                graph.computeIfAbsent(email, t -> new TreeSet<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), t -> new TreeSet<>()).add(email);
            }
        }

        HashSet<String> set = new HashSet<>();// visited  Email
        List<String> emailList = new LinkedList<>();
        for (String email : graph.keySet()) {
            if (!set.contains(email)) {
                dfs(email, emailList, set, graph);
                Collections.sort(emailList);

                emailList.addFirst(emailToName.get(email)); // add name
                resList.add(new LinkedList<>(emailList));
                emailList.clear();
            }
        }

        return resList;
    }

    private void dfs(String email, List<String> emailList, HashSet<String> set, HashMap<String, TreeSet<String>> graph) {
        set.add(email);
        emailList.add(email);
        TreeSet<String> emails = graph.get(email);
        for (String nextEmail : emails) {
            if (!set.contains(nextEmail)) {
                dfs(nextEmail, emailList, set, graph);
            }
        }
    }


}


