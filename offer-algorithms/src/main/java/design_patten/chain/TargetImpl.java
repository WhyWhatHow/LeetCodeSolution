package design_patten.chain;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-03-31 22:09
 **/
public class TargetImpl  implements  Target{

    @Override
    public String execute(String sql) {
        System.out.println( " execute () "+sql );
        return sql;
    }
}
