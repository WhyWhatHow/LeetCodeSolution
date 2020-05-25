package Solution;
/***
 * 242. Valid Anagram
  Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.


 */

/**
 * hash 打表
 */
public class Solution242 {
    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();
        boolean res1 = solution242.isAnagram("anagram", "nagaram");
        boolean res2 = solution242.isAnagram("rat", "car");
        System.out.println(res1+" "+res2);
    }
    public boolean isAnagram(String s, String t) {
//        Integer
        int[] a = new int[26];
//        for(int i = 0 ; i< 0 ; i++){
//            a[i] = 0 ;
//        }
        for (int i = 0 ; i<s.length(); i++){
            a[s.charAt(i)-'a']++;
            a[t.charAt(i)-'a']--;
        }
        boolean result = true;
        for(int i = 0 ; i<1000;i++){
            if(a[i]>0){
                result =false ;
                break ;
            }
        }
        return result;
    }
}
