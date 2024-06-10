package leetcode.algorithm.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_131 {

    public static void main(String[] args) {
        Solution_131 sol = new Solution_131();
        System.out.println("==================");
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java version: " + javaVersion);
    }

    public List<List<String>> partition(String s) {
        List res = new LinkedList();
        LinkedList temp = new LinkedList<String>();
        dfs(res, temp, new StringBuilder(),s);
        return res ;
    }

    void dfs(List res, LinkedList temp,StringBuilder str,String s) {
        if (isPalindrome(str.toString())) // isPalindrome
        {
            temp.add(str.toString());
            return ;
        }
        for(int i =0 ; i<s.length() ;i++){
            str.append(s.charAt(i));

        }
    }

    private boolean isPalindrome(String s) {
        if(s.length() ==1) return true;
        int r = s.length()-1;
        int l = 0 ;
        while(l<=r){
            if(s.charAt(l) !=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}


