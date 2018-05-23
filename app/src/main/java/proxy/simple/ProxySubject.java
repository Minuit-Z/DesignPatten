package proxy.simple;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class ProxySubject implements Subject{

    private RealSubject subject;

    //获取真实对象的引用
    public ProxySubject(RealSubject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        //通过真实对象调用方法
        subject.visit();
    }
}
