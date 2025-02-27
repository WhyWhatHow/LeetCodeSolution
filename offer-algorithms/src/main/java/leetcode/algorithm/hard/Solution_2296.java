package leetcode.algorithm.hard;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2296 {

    public static void main(String[] args) {
        Solution_2296 sol = new Solution_2296();
        System.out.println("==================");

        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        textEditor.deleteText(4); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        textEditor.cursorRight(3); // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        textEditor.cursorLeft(8); // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        textEditor.cursorLeft(2); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.cursorRight(6); // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
    }


}


class TextEditor {
    Stack<Character> ls = new Stack<>();  // 光标左侧的text
    Stack<Character> rs = new Stack<>(); // 光标右侧的text

    public TextEditor() {

    }

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++) {
            ls.push(text.charAt(i));
        }
    }

    //
    public int deleteText(int k) {
        int cnt = 0;
        while (!ls.isEmpty() && k-- > 0) {
            cnt++;
            ls.pop();
        }
        return cnt;
    }

    public String cursorLeft(int k) {
        // remove cursor
        while (!ls.isEmpty() && k-- > 0) {
            rs.push(ls.pop());
        }
        int len = Math.min(ls.size(), 10);
        return getSubStr(len);
    }

    // 返回左侧长度为len 的sub string.
    private String getSubStr(int len) {
        StringBuilder sb = new StringBuilder();
        while (!ls.isEmpty() && len-- > 0) {
            sb.append(ls.pop());
        }
        String s = sb.reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            ls.push(s.charAt(i));
        }
        return s;
    }

    public String cursorRight(int k) {
        while (!rs.isEmpty() && k-- > 0) {
            ls.push(rs.pop());
        }
        int len = Math.min(ls.size(), 10);
        return getSubStr(len);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */