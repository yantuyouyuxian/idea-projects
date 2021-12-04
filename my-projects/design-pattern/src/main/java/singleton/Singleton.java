package singleton;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/2 10:53
 * @ Description    单例模式
 */
public class Singleton {

    // 私有构造函数
    private Singleton() {
    }
    // 饿汉式，
    // 优点：在类装载的时候就完成实例化。避免了线程同步问题
    // 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费

//    private static final Singleton instance = new Singleton();
//    public static Singleton getInstance() {
//        return instance;
//    }

    // 懒汉式
    //优点：延迟加载
    //缺点：如果在多线程下，一个线程进入了if (singleton == null)判断语句块，
    //     还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式

//    private static Singleton instance;
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    // 双重锁机制
    //核心：如果不进行第二次判空，就会出现A线程构建完对象释放锁，线程B获得锁构建第二个对象的情况
    //缺陷：正常构建对象的步骤：1.分配内存空间，2.初始化对象，3.指向内存地址
    //     但是如果进行了指令重排，就可能会让2，3两个步骤反过来，
    //     这样在B线程进入第一个判空时，就可能会拿到一个未初始化完成的对象
//    private static Singleton instance = null;
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    // volatile版本
    // 这里利用了volatile修饰符阻止了变量访问前后的指令重排
//    private volatile static Singleton instance = null;
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    //静态内部类
    // INSTANCE对象初始化的时机并不是在单例类Singleton被加载的时候，
    // 而是在调用getInstance方法，使得静态内部类LazyHolder被加载的时候。
    // 因此这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。
    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }


}
