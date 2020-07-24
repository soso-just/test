package coding.internal;

import java.util.concurrent.locks.ReentrantLock;

public class InternalDemo {


    private static final int STATIC_PROPERTITY = 1;
    private int propertity = 2;

    private InternalClass internalClass = new InternalClass();

    public int visitInternal(){
        return internalClass.getOut();
    }

    class InternalClass{
        public int getOut(){
            return STATIC_PROPERTITY;
        }
    }

    public static void main(String[] args) {
        InternalDemo internalDemo= new InternalDemo();
        System.out.println(internalDemo.visitInternal());
    }
}
