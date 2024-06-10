package other;

/**
 * @program: LeetCodeSolution
 * @description: 运算表达式,
 * @author: WhyWhatHow
 * @create: 2021-06-04 11:41
 **/
public class Expression {
    String op;

    public Expression() {
    }

    public Expression(String op, Integer a, Integer b) {
        this.op = op;
        this.a = a;
        this.b = b;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    Integer a; // 第一个操作数
    Integer b; // 第二个操作数

    //// TODO: 2021/6/4 未解决 数据超过Integer.max_val 的限制 
    Object getRes() {
        if ("add".equals(op)) {
            return a + b;
        } else if ("mult".equals(op)) {
            return a * b;
        } else {
            return "Bad request";
        }
    }

}
