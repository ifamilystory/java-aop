import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello AOP!");
        UserActionImp target = new UserActionImp();
        UserActionInterface delgate = (UserActionInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new AOPHander<UserActionImp>(target));
        /*通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，
        也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。*/
        System.out.println(delgate.getClass().getName());
        delgate.doSomethoing();
    }
}
