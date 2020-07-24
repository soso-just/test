package coding.classorder;
/**
 * @Description TODO
 * @author chengyafei
 * @createTime 2020年07月24日 19:38:00
 */
public class baba extends yeye {
    static {
        System.out.println("爸爸静态代码块");
    }

    static int babaint = 1;

    public baba() {
        System.out.println("爸爸构造器");
    }
}
