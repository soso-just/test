package coding.classorder;
/**
 * @Description TODO
 * @author chengyafei
 * @createTime 2020年07月24日 19:40:00
 */
public class erzi extends baba {
    static {
        System.out.println("儿子静态代码块");
    }

    public erzi() {
        System.out.println("儿子构造器");
    }
}
