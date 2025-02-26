package leetcode.algorithm.medium;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1472 {

    public static void main(String[] args) {
        Solution_1472 sol = new Solution_1472();
        System.out.println("==================");
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(5));                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"

    }



}
class BrowserHistory {

    Stack<String> bs = new Stack<>();  // go back
    Stack<String> fs = new Stack<>();// go forward
    String homepage;

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        bs.add(homepage);
    }

    public void visit(String url) {
        fs.clear();
        bs.push(url);
    }

    public String back(int steps) {
        while (!bs.isEmpty() && steps-- > 0) {
            String pop = bs.pop();
            // hint homepage can't add to forward stack.
            if (!homepage.equals(pop))
                fs.push(pop);
        }
        return !bs.isEmpty() ? bs.peek() : bs.push(homepage);
    }

    public String forward(int steps) {
        if (fs.isEmpty()) return bs.peek();
        String last = "";
        while (!fs.isEmpty() && steps-- > 0) {
            last = fs.pop();
            bs.push(last);
        }
        return last;

    }
}